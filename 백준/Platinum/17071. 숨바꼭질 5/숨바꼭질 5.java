import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        bw.write(String.valueOf(bfs(n, k)));
        bw.close();
        br.close();
    }

    private static int bfs(int n, int k) {
        if(n == k)
            return 0;

        Queue<Integer> que = new ArrayDeque<>();
        que.add(n);

        boolean[][] visit = new boolean[500001][2];
        visit[n][0] = true;

        int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 } };

        int time = 0;
        while(!que.isEmpty()){
            int size = que.size();

            time++;
            k+=time;

            if(k > 500_000)
                break;

            while(size-- > 0){
                int cur = que.poll();

                for(int i=0 ; i<3 ; i++){
                    int next = cur + move[i][0] + cur * move[i][1];

                    if(next < 0 || next > 500_000 || visit[next][time % 2])
                        continue;

                    que.add(next);
                    visit[next][time % 2] = true;
                }
            }

            if(visit[k][time % 2])
                return time;
        }


        return -1;
    }

}