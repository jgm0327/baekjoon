import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    private static final int[] dy = {-1, 0, 1};
    private static int n, m;
    private static char[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        board = new char[n][m];
        for(int i=0 ; i<n ; i++){
            String input = br.readLine();
            for(int j=0 ; j<m ; j++){
                board[i][j] = input.charAt(j);
            }
        }

        int answer = 0;
        for(int i=0 ; i<n ; i++){
            if(!dfs(i, 0))continue;
            answer++;
        }
        System.out.println(answer);
    }

    private static boolean dfs(int y, int x){
        if(x == m - 1){
            return true;
        }
        
        for(int i=0 ; i<3 ; i++){
            int ny = y + dy[i], nx = x + 1;
            if(0 > ny || ny >= n || board[ny][nx] == 'x')continue;

            board[ny][nx] = 'x';
            if(dfs(ny, nx))return true;
            board[ny][nx] = '.';

        }

        for(int i=0 ; i<3 ; i++){
            int ny = y + dy[i], nx = x + 1;
            if(0 > ny || ny >= n || board[ny][nx] == 'x')continue;
            board[ny][nx] = 'x';
        }

        return false;
    }
}