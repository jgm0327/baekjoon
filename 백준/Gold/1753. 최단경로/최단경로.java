import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    private static int n;
    private static List<int[]>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for(int i=1 ; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());
            int sour, des, cost;

            sour = Integer.parseInt(tokenizer.nextToken());
            des = Integer.parseInt(tokenizer.nextToken());
            cost = Integer.parseInt(tokenizer.nextToken());

            graph[sour].add(new int[]{des, cost});
        }

        int[] costs = dijkstra(start);
        StringBuilder answer = new StringBuilder();

        for(int i=1 ; i<=n ; i++){
            answer.append(costs[i] == Integer.MAX_VALUE ? "INF" : costs[i]).append("\n");
        }

        System.out.print(answer);
    }

    private static int[] dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int sour = cur[0], cost = cur[1];

            if(costs[sour] < cost)
                continue;

            for(int[] next : graph[sour]){
                int des = next[0], nextCost = next[1] + cost;
                if(nextCost >= costs[des])
                    continue;
                
                costs[des] = nextCost;
                pq.add(new int[]{des, nextCost});
            }
        }

        return costs;
    }
}