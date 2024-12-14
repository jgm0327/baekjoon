import java.io.*;
import java.util.*;

class Main {
    private static int n, k;
    private static List<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList[n + 1];
        for(int i=1 ; i<=n ; i++)
            graph[i] = new ArrayList<>();

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());
            int dist = Integer.parseInt(tokenizer.nextToken());

            graph[sour].add(new int[]{des, dist});
            graph[des].add(new int[]{sour, dist});
        }
        
        bw.write(String.valueOf(dijkstra()));
        bw.close();
        br.close();
    }

    private static long dijkstra(){
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] < o2[1])
                return -1;
            else if(o1[1] > o2[1])
                return 1;
            return 0;
        });

        pq.add(new long[]{1, 0, 0});

        long[][] dp = new long[n + 1][k + 1];
        for(int i=1; i<=n ; i++){
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        Arrays.fill(dp[1], 0);

        while(!pq.isEmpty()){
            long[] cur = pq.poll();

            int sour = (int)cur[0], kCnt = (int)cur[2];
            long dist = cur[1];

            if(dp[sour][kCnt] < dist)
                continue;

            for(int[] next : graph[sour]){
                int des = next[0];
                long nextCost = dist + next[1];

                if(dp[des][kCnt] > nextCost){
                    dp[des][kCnt] = nextCost;
                    pq.add(new long[]{des, nextCost, kCnt});
                }

                if(kCnt < k && dp[des][kCnt + 1] > dist){
                    dp[des][kCnt + 1] = dist;
                    pq.add(new long[]{des, dist, kCnt + 1});
                }
            }
        }

        long ret = Long.MAX_VALUE;
        for(int i=1 ; i<=k ; i++){
            ret = Math.min(ret, dp[n][i]);
        }
        return ret;
    }
}