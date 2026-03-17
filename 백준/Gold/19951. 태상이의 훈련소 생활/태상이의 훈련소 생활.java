import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] heights = new int[n + 1];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++)
            heights[i] = Integer.parseInt(tokenizer.nextToken());
        
        Map<Integer, Integer> prefix = new HashMap<>();
        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());

            prefix.put(start, prefix.getOrDefault(start, 0) + value);
            prefix.put(end + 1, prefix.getOrDefault(end + 1, 0) - value);
        }

        int total = 0;
        for(int i=1 ; i<=n ; i++){
            if(prefix.containsKey(i))
                total += prefix.get(i);

            heights[i] += total;
        }

        StringBuilder answer = new StringBuilder();
        for(int i=1 ; i<=n ; i++){
            answer.append(heights[i]).append(" ");
        }

        System.out.println(answer);

        br.close();
    }
}