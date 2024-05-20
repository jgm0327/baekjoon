import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());

            graph[sour].add(des);
        }

        int[] costs = dijkstra(x, n, graph);

        StringBuilder answer = new StringBuilder();
        for(int i=1 ; i<=n ; i++){
            if(costs[i] != k)continue;
            answer.append(i).append("\n");
        }

        System.out.print(answer.length() > 0 ? answer : -1);
    }

    private static int[] dijkstra(int start, int n, List<Integer>[] graph){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});

        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int sour = cur[0], dist = cur[1];

            if(costs[sour] < dist)continue;

            for(int des : graph[sour]){
                int nextDist = dist + 1;

                if(nextDist >= costs[des])continue;

                costs[des] = nextDist;
                pq.add(new int[]{des, nextDist});
            }
        }

        return costs;
    }
}
