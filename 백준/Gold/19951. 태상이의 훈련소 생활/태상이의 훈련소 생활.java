import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, Integer> prefix = new HashMap<>();
        int[] heights = new int[n];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            heights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for(int i=0 ; i<m ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int h = Integer.parseInt(tokenizer.nextToken());

            prefix.put(start, prefix.getOrDefault(start, 0) + h);
            prefix.put(end + 1, prefix.getOrDefault(end + 1, 0) - h);
        }

        StringBuilder answer = new StringBuilder();
        int total = 0;
        for(int i=0 ; i<n ; i++){
            total += prefix.getOrDefault(i + 1, 0);

            answer.append(total + heights[i]).append(" ");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}