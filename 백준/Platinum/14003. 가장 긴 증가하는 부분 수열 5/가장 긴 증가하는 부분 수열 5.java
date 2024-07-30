import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        int[] numbers = new int[n];
        int[] indices = new int[n];
        List<Integer> list = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        list.add(Integer.MIN_VALUE);

        for(int i=0 ; i<n ; i++){
            if(numbers[i] > list.get(list.size() - 1)){
                list.add(numbers[i]);
                indices[i] = list.size() - 1;
                continue;
            }

            int idx = bisectLeft(list, numbers[i]);
            indices[i] = idx;
            list.set(idx, numbers[i]);
        }

        int idx = list.size() - 1;
        ArrayDeque<Integer> answer = new ArrayDeque<>();

        for(int i=n-1 ; i>=0 ; i--){
            if(indices[i] == idx){
                idx--;
                answer.add(numbers[i]);
            }
        }

        bw.append(String.valueOf(answer.size())).append("\n");

        while(!answer.isEmpty()){
            bw.append(String.valueOf(answer.pollLast())).append(" ");
        }

        bw.flush();

        bw.close();
        br.close();
    }

    private static int bisectLeft(List<Integer> number, int target){
        int left = 0, right = number.size() - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(number.get(mid) >= target)right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}