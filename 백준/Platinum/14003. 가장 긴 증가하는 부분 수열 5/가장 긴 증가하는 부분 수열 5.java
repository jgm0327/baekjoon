import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int[] indexOfNumber = new int[n];

        List<Integer> list = new ArrayList<>();

        int[] numbers = new int[n];
        for(int i=0 ; i<n ; i++){
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
            
            if(list.isEmpty() || list.get(list.size() - 1) < numbers[i]){
                list.add(numbers[i]);
                indexOfNumber[i] = list.size() - 1;
                continue;
            }

            int idx = bisectLeft(list, numbers[i]);
            list.set(idx, numbers[i]);
            indexOfNumber[i] = idx;
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(list.size()).append('\n');

        int[] temp = new int[list.size()];
        int idx = list.size() - 1;

        for(int i=n-1 ; i>=0 ; i--){
            if(idx == indexOfNumber[i])
                temp[idx--] = numbers[i];
        }

        for(int i=0 ; i<temp.length ; i++){
            answer.append(temp[i]).append(" ");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }

    private static int bisectLeft(List<Integer> list, int target){
        int left = 0, right = list.size() - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(target <= list.get(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}