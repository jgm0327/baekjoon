import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        List<int[]>[] graph = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++)
            graph[i] = new ArrayList<>();

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());
            int dist = Integer.parseInt(tokenizer.nextToken());

            graph[sour].add(new int[]{des, dist});
        }

        bw.write(dijkstra(graph, n, k));
        bw.close();
        br.close();
    }

    private static String dijkstra(final List<int[]>[] graph, int n, int k){
        PriorityQueue<Integer>[] orderCounts = new PriorityQueue[n + 1];
        for(int i=0 ; i<=n ; i++){
            orderCounts[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        orderCounts[1].add(0);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] > o2[1])
                return 1;
            else if(o1[1] < o2[1])
                return -1;
            return 0;
        });

        pq.add(new int[]{1, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int sour = cur[0], dist = cur[1];
            for(int[] des : graph[(int)sour]){
                int nextDist = dist + des[1];
                int point = (int)des[0];

                if(orderCounts[point].size() == k 
                && orderCounts[point].peek() < nextDist)
                    continue;

                if(orderCounts[point].size() == k)
                    orderCounts[point].poll();

                orderCounts[point].add(nextDist);
                pq.add(new int[]{point, nextDist});
            }
        }

        StringBuilder ret = new StringBuilder();
        for(int i=1 ; i<=n ; i++){
            long kthDist = -1;
            if(orderCounts[i].size() == k)
                kthDist = orderCounts[i].peek();

            ret.append(kthDist).append('\n');
        }

        return ret.toString();
    }
}