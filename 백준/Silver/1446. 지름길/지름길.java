import java.io.*;
import java.util.*;

class Main {
    private static class ShortCut implements Comparable<ShortCut>{
        int start, end, dist;

        public ShortCut(int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(ShortCut o){
            if(o.start != this.start) return this.start - o.start;
            else if(o.end != this.end) return this.end - o.end;
            return this.dist - o.dist;
        }

        @Override
        public String toString(){
            return this.start + " " + this.end + " " + this.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int d = Integer.parseInt(tokenizer.nextToken());

        PriorityQueue<ShortCut> pq = new PriorityQueue<>();
        
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int dist = Integer.parseInt(tokenizer.nextToken());

            pq.add(new ShortCut(start, end, dist));
        }

        int[] dp = new int[d + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        while(!pq.isEmpty()){
            ShortCut shortCut = pq.poll();
            
            if(shortCut.end > d)
                continue;

            int minValue = Integer.MAX_VALUE;
            for(int prev = 0 ; prev <= shortCut.start ; prev++){
                if(dp[prev] == Integer.MAX_VALUE)
                    continue;

                minValue = Math.min(dp[prev] + (shortCut.start - prev) + shortCut.dist, minValue);
            }

            dp[shortCut.end] = Math.min(minValue, dp[shortCut.end]);
        }

        for(int prev = 0 ; prev < d ; prev++){
            if(dp[prev] == Integer.MAX_VALUE)
                continue;

            dp[d] = Math.min(dp[prev] + (d - prev), dp[d]);
        }

        bw.write(String.valueOf(dp[d]));
        bw.close();
        br.close();
    }
}