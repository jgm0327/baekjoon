import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> prefix = new HashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] height = new int[n + 1];
        tokenizer = new StringTokenizer(br.readLine());

        for(int i=1 ; i<=n ; i++){
            height[i] = Integer.parseInt(tokenizer.nextToken());
        }

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int amount = Integer.parseInt(tokenizer.nextToken());

            prefix.put(start, prefix.getOrDefault(start, 0) + amount);
            prefix.put(end + 1, prefix.getOrDefault(end + 1, 0) - amount);
        }

        int amount = 0;

        for(int i=1 ; i<=n ; i++){
            if(prefix.containsKey(i)) {
                amount += prefix.get(i);
            }

            bw.append(String.valueOf(height[i] + amount)).append(" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}