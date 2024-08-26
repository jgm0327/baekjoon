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

            if(list.isEmpty() || list.get(list.size() - 1) < numbers[i]){
                list.add(numbers[i]);
                indices[i] = list.size() - 1;
                continue;
            }

            int idx = bisectLeft(list, numbers[i]);

            indices[i] = idx;
            list.set(idx, numbers[i]);
        }

        StringBuilder answer = new StringBuilder();
        int size = list.size() - 1;

        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for(int i=n-1 ; i>=0 ; i--){
            if(indices[i] == size){
                size--;
                stk.add(numbers[i]);
            }
        }

        answer.append(stk.size()).append("\n");
        while(!stk.isEmpty()){
            answer.append(stk.pollLast()).append(" ");
        }
        
        bw.write(answer.toString());
        bw.close();
        br.close();
    }

    private static int bisectLeft(List<Integer> list, int target){
        int left = 0, right = list.size() - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(target > list.get(mid))left = mid + 1;
            else right = mid - 1; 
        }

        return left;
    }
}