import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    private static int n, m, t;
    private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    private static char[][] board;
    private static Queue<int[]> bombs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());

        board = new char[n][m];
        bombs = new LinkedList<>();
        for(int i=0 ; i<n ; i++){
            String str = br.readLine();
            for(int j=0 ; j<m ; j++){
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'O')bombs.add(new int[]{i, j});
            }
        }

        int time = 1;
        while(time < t){
            time++;
            if(time % 2 == 0)setBomb();
            else if(time % 2 == 1)explod();
        }

        StringBuilder answer = new StringBuilder();

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                answer.append(board[i][j]);
            }
            answer.append("\n");
        }
        System.out.println(answer);
        br.close();
    }

    private static void setBomb(){
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(board[i][j] == 'O')bombs.add(new int[]{i, j});
                board[i][j] = 'O';
            }
        }
    }

    private static void explod(){
        while(!bombs.isEmpty()){
            int[] cur = bombs.poll();
            int y = cur[0], x = cur[1];
            board[y][x] = '.';
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m)continue;
                board[ny][nx] = '.';
            }
        }
    }
}