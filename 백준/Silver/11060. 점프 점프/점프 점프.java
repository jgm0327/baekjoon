import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    private static int n;
    private static int[] maze;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        maze = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            maze[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(bfs());

    }

    private static int bfs(){
        if(0 == n - 1)
            return 0;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});

        boolean[] visit = new boolean[n + 1];

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int num = cur[0], cnt = cur[1];

            for(int jump=1 ; jump<=maze[num] ; jump++){
                int nextNum = num + jump;

                if(nextNum == n - 1)
                    return cnt + 1;

                if(nextNum >= n || visit[nextNum])continue;

                que.add(new int[]{nextNum, cnt + 1});
                visit[nextNum] = true;
            }
        }
        
        return -1;
    }
}