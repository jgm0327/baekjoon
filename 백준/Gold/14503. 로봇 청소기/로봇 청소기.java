import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    private static final int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    private static int n, m, d;
    private static int[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        board = new int[n][m];

        stk = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());

        for(int i=0 ; i<n ; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0 ; j < m ; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int answer = 1;
        board[r][c] = 2;
        while(true){

            if(aroundDirt(r, c)){
                d--;
                if(d < 0)d = 3;
                int[] move = moveRobot(r, c);
                r = move[0];
                c = move[1];
                if(board[r][c] == 0){
                    answer++;
                    board[r][c] = 2;
                }
                continue;
            }

            int nr = r + (-dy[d]), nc = c + (-dx[d]);

            if(!isIn(nr, nc) || board[nr][nc] == 1)
                break;

            r = nr;
            c = nc;
            
        }

        System.out.println(answer);
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    private static int[] moveRobot(int r, int c){
        int ny = r + dy[d], nx = c + dx[d];
        if(isIn(ny, nx) && board[ny][nx] == 0)return new int[]{ny, nx};
        return new int[]{r, c};
    }

    private static boolean aroundDirt(int r, int c){
        for(int i=0 ; i<4 ; i++){
            int nr = r + dy[i], nc = c + dx[i];
            if(isIn(r, c) && board[nr][nc] == 0)return true;
        }

        return false;
    }
}