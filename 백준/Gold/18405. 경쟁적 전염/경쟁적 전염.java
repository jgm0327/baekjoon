import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    private static int n, m;
    private static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new int[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for(int i=0 ; i<n ; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++){
                graph[i][j] = Integer.parseInt(stk.nextToken());
                if(graph[i][j] == 0)continue;
                pq.add(new int[]{graph[i][j], i, j});
            }
        }

        int s, y, x;

        stk = new StringTokenizer(br.readLine());
        s = Integer.parseInt(stk.nextToken());
        y = Integer.parseInt(stk.nextToken());
        x = Integer.parseInt(stk.nextToken());

        while(s-- > 0){
            spread(pq);
        }        

        System.out.println(graph[y - 1][x - 1]);
    }

    private static void spread(PriorityQueue<int[]> pq){
        PriorityQueue<int[]> tempPq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int num = cur[0], y = cur[1], x = cur[2];

            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                if(0 > ny || ny >= n || 0 > nx || nx >= n || graph[ny][nx] != 0)
                    continue;
                
                graph[ny][nx] = num;
                tempPq.add(new int[]{num, ny, nx});
            }
        }

        pq.addAll(tempPq);
    }
}