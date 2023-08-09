import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    private static int n, m, v;
    private static int[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        v = Integer.parseInt(stk.nextToken());

        graph = new int[n+1][n+1];
        for(int i=0 ; i<m ; i++){
            stk = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(stk.nextToken()), des = Integer.parseInt(stk.nextToken());
            graph[sour][des] = graph[des][sour] = 1;
        }
        dfs(v, new boolean[n + 1]);
        System.out.println();
        bfs();
        br.close();
    }

    private static void dfs(int sour, boolean[] visit){
        System.out.print(sour+ " ");
        visit[sour] = true;
        for(int i=1; i<=n ; i++){
            if(graph[sour][i] == 0 || visit[i])continue;
            dfs(i, visit);
        }
    }

    private static void bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        boolean[] visit = new boolean[n + 1];
        visit[v] = true;

        while(!que.isEmpty()){
            int sour = que.poll();
            System.out.print(sour + " ");
            for(int i=1 ; i<=n ; i++){
                if(graph[sour][i] == 0 || visit[i])continue;
                que.add(i);
                visit[i] = true;
            }
        }
    }
}