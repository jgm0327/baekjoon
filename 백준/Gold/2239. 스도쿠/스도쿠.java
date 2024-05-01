import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main{

    private static boolean isOver = false;
    private static int[][] board;
    private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        List<int[]> zeros = new ArrayList<>();

        for(int i=0 ; i<9 ; i++){
            String str = br.readLine();

            for(int j=0 ; j<9 ; j++){
                board[i][j] = str.charAt(j) - '0';
                if(board[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }

        dfs(0, zeros);

        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void dfs(int depth, final List<int[]> zeros) {
        if(depth == zeros.size()){
            isOver = true;
            return;
        }
        
        int[] cur = zeros.get(depth);
        
        int y = cur[0], x = cur[1];
        for(int number = 1 ; number < 10 ; number++){
            if(isOver)return;

            if(!linear(y, x, number) || !square(y, x, number))
                continue;

            board[y][x] = number;
            dfs(depth + 1, zeros);
            if(isOver)return;
            board[y][x] = 0;
        }
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < 9 && 0 <= x && x < 9;
    }

    private static boolean linear(int y, int x, int number){
        for(int i=0 ; i<4 ; i++){
            for(int j=1 ; j<9 ; j++){
                int ny = y + dy[i] * j, nx = x + dx[i] * j;

                if(!isIn(ny, nx))break;

                if(board[ny][nx] == number)return false;
            }
        }

        return true;
    }
    
    private static boolean square(int y, int x, int number){
        int startY = (y / 3) * 3, startX = (x / 3) * 3;

        for(int i= startY ; i < startY + 3 ; i++){
            for(int j = startX ; j < startX + 3 ; j++){
                if(board[i][j] == number)return false;
            }   
        }

        return true;
    }
}