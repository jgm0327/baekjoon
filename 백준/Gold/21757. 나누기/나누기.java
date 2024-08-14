import java.io.*;
import java.util.*;

class Main {
    static class ShortCut implements Comparable<ShortCut>{
        int start, end, len, totalDist;

        public ShortCut(int start, int end, int len){
            this.start = start;
            this.end = end;
            this.len = len;
            totalDist = start;
        }

        @Override
        public int compareTo(ShortCut o){
            if(o.start != this.start)return this.start - o.start;
            return o.len - this.len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] prefixSum = new int[n + 1];
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());

            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        long answer = solution(prefixSum, n);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();

        br.close();
    }

    private static long solution(final int[] prefixSum, int n){
        if(prefixSum[n] % 4 > 0)
            return 0;


        if(prefixSum[n] == 0){
            int cnt = 0;
            for(int i=1 ; i<prefixSum.length ; i++){
                if(prefixSum[i] == 0)
                    cnt++;
            }

            return (cnt - 1) * (cnt - 2) * (cnt - 3) / 6;
        }

        int k = prefixSum[n] / 4;
        long[] dp = new long[5];

        dp[0] = 1;
        for(int i=1 ; i<=n ; i++){
            int t = prefixSum[i] / k;

            if(prefixSum[i] % k != 0 || t < 1 || t > 4)continue;

            dp[t] += dp[t - 1];
        }

        return dp[4];
    }

}