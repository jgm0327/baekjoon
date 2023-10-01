import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    private static int n, m;
    private static List<int[]>[] graph;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[n + 1];
        for(int i=0 ; i<n+1 ; i++){
            graph[i] = new ArrayList<>();
        }

        while(m-- > 0 ){
            stk = new StringTokenizer(br.readLine());
            int sour, des, weight;
            sour = Integer.parseInt(stk.nextToken());
            des = Integer.parseInt(stk.nextToken());
            weight = Integer.parseInt(stk.nextToken());

            graph[sour].add(new int[]{des, weight});
            graph[des].add(new int[]{sour, weight});
        }

        stk = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(stk.nextToken()), target2 = Integer.parseInt(stk.nextToken());

        long path1 = 0, path2 = 0;

        path1 = dijkstra(1, target1);
        path1 += dijkstra(target1, target2);
        path1 += dijkstra(target2, n);

        path2 = dijkstra(1, target2);
        path2 += dijkstra(target2, target1);
        path2 += dijkstra(target1, n);

        long answer = Math.min(path1, path2);
        System.out.println(answer >= Integer.MAX_VALUE ? -1 : answer);

        br.close();
    }

    private static int dijkstra(int start, int end){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;
        pq.add(new int[]{start, costs[start]});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int sour = cur[0], cost = cur[1];
            if(costs[sour] < cost)continue;
            
            for(int[] next : graph[sour]){
                int des = next[0], nextCost = cost + next[1];
                if(nextCost >= costs[des])continue;
                costs[des] = nextCost;
                pq.add(new int[]{des, nextCost});
            }
        }
        return costs[end];
    }
}