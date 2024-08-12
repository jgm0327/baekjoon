import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        StringBuilder answer = new StringBuilder();
        ArrayDeque<int[]> stk = new ArrayDeque<>();
        int[] indices = new int[n];

        for(int i=n-1 ; i>=0 ; i--){
            while(!stk.isEmpty() && stk.peekLast()[1] < numbers[i]){
                indices[stk.pollLast()[0]] = i + 1;
            }

            stk.add(new int[]{i, numbers[i]});
        }

        while (!stk.isEmpty()) {
            indices[stk.pollLast()[0]] = 0;
        }

        for(int index : indices){
            answer.append(index).append(" ");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();

        br.close();
    }
}