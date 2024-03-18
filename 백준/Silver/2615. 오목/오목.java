import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    private static int[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[19][19];

        for(int i=0 ; i<19 ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0 ; j<19 ; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        solution();
    }

    private static void solution(){
        for(int i = 0 ; i<19 ; i++){
            for(int j=0 ; j<19 ; j++){
                if(board[i][j] == 0)
                    continue;

                int exist = existWinner(i, j);
                if(exist == 0)continue;

                System.out.println(board[i][j]);
                if(exist == 1){
                    System.out.println((i + 1) + " " + (j + 1));
                }
                else if(exist == -1){
                    System.out.println((i + 5) + " " + (j - 3));
                }
                return;
            }
        }

        System.out.println(0);
    }

    private static int existWinner(int y, int x){

        if(check(y, x, 1, -1) + check(y, x, -1, 1)== 4)return -1;
        if(check(y, x, 1, 1) + check(y, x, -1, -1) == 4)return 1;
        if(check(y, x, 0, 1) + check(y, x, 0, -1) == 4)return 1;
        if(check(y, x, 1, 0) + check(y, x, -1, 0)== 4)return 1;
        
        return 0;
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < 19 && 0 <= x && x < 19;
    }

    private static int check(int y, int x, int mulY, int mulX){
        int ret = 0, original = board[y][x];

        for(int i=1 ; i<20 ; i++){
            int ny = y + mulY * i, nx = x + mulX * i;
            if(!isIn(ny, nx) || board[ny][nx] != original)break;
            ret++;
        }

        return ret;
    }
}