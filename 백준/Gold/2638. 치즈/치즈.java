import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main{
    private static int n, m, total;
    private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    private static boolean[][] visit;
    private static int[][] board;
    private static ArrayDeque<int[]> cheese;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        board = new int[n][m];

        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
                if(board[i][j] == 1)total++;
            }
        }

        int time = 0;
        cheese = new ArrayDeque<>();

        while(total > 0){
            time++;
            visit = new boolean[n][m];

            findMeltingCheese(0, 0);
            meltCheese();
        }

        System.out.println(time);
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    private static void findMeltingCheese(int startY, int startX){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startY, startX});

        visit[startY][startX] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];

            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(!isIn(ny, nx) || visit[ny][nx])
                    continue;

                visit[ny][nx] = true;

                if(board[ny][nx] == 1){
                    cheese.add(new int[]{ny, nx});
                    continue;
                }

                que.add(new int[]{ny, nx});
            }
        }
    }

    private static boolean cheeseAroundEmptySpaceCount(int y, int x){
        int ret = 0;

        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];

            if(!isIn(ny, nx))
                continue;

            if(board[ny][nx] == 0 && visit[ny][nx]){
                ret++;
            }
        }

        return ret >= 2;
    }

    private static void meltCheese(){
        while(!cheese.isEmpty()){
            int[] cur = cheese.poll();

            if(!cheeseAroundEmptySpaceCount(cur[0], cur[1]))
                continue;

            total--;
            board[cur[0]][cur[1]] = 0;
            visit[cur[0]][cur[1]] = false;
        }
    }
}