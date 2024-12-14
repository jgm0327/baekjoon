import java.io.*;
import java.util.*;

class Main {

    private static class Node implements Comparable<Node>{
        int x, dist;

        public Node(int x, int dist){
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }

    private static int n;
    private static List<int[]>[] graph;
    private static List<Integer>[] remove;
    private static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder answer = new StringBuilder();
        while(true){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            if(n == 0 && m == 0)
                break;

            tokenizer = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            graph = new ArrayList[n];
            remove = new ArrayList[n];
            for(int i=0 ; i<n ; i++){
                graph[i] = new ArrayList<>();
                remove[i] = new ArrayList<>();
            }

            while(m-- > 0){
                tokenizer = new StringTokenizer(br.readLine());

                int sour = Integer.parseInt(tokenizer.nextToken());
                int des = Integer.parseInt(tokenizer.nextToken());
                int dist = Integer.parseInt(tokenizer.nextToken());

                graph[sour].add(new int[]{des, dist});
            }
            
            visit = new boolean[n][n];
            dijkstra(start, end);
            removeEdges(start, end);
            answer.append(dijkstra(start, end)).append('\n');
        }
        
        bw.write(answer.toString());
        bw.close();
        br.close();
    }

    private static int dijkstra(int start, int end){
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            int sour = cur.x, dist = cur.dist;
            if(dist > costs[sour])
                continue;

            for(int[] des : graph[sour]){
                int x = des[0], nextCost = des[1] + dist;

                if(nextCost > costs[x] || visit[sour][x])
                    continue;

                if(nextCost != costs[x]){
                    Node node = new Node(x, nextCost);
                    costs[x] = nextCost;
                    pq.add(node);
                    remove[x] = new ArrayList<>();
                    remove[x].add(sour);
                }
                else
                    remove[x].add(sour);
            }
        }

        if(costs[end] == Integer.MAX_VALUE)
            return -1;

        return costs[end];
    }

    private static void removeEdges(int start, int end){
        if(start == end)
            return;

        for(int des : remove[end]){
            if(visit[des][end])
                continue;

            visit[end][des] = visit[des][end] = true;
            removeEdges(start, des);
        }
    }
}