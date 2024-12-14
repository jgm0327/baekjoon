import java.io.*;
import java.util.*;

class Main {

    private static int n;
    private static List<int[]>[] graph;
    private static int[][] firstVertex;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());
            int dist = Integer.parseInt(tokenizer.nextToken());

            graph[sour].add(new int[]{des, dist});
            graph[des].add(new int[]{sour, dist});
        }

        firstVertex = new int[n + 1][n + 1];
        for(int start=1 ; start<=n ; start++){
            dijkstra(start);
        }

        StringBuilder answer = new StringBuilder();
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                if(0 == firstVertex[i][j])
                    answer.append("- ");
                else
                    answer.append(firstVertex[i][j]).append(" ");
            }
            answer.append('\n');
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // point, dist, 처음 정점
        pq.add(new int[]{start, 0, 0});

        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int sour = cur[0], dist = cur[1], first = cur[2];

            if(costs[sour] < dist)
                continue;

            for(int[] des : graph[sour]){
                int x = des[0], nextCost = des[1] + costs[sour], nextFirst = first;
                
                if(nextCost > costs[x])
                    continue;

                if(first == 0)
                    nextFirst = x;

                if(costs[x] != nextCost)
                    firstVertex[start][x] = nextFirst;
                costs[x] = nextCost;
                pq.add(new int[]{x, nextCost, nextFirst});
            }
        }
    }
}