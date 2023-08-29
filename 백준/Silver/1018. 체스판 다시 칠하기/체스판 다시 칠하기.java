import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    private static int n, m;
    private static char[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        board = new char[n][m];
        for(int i=0 ; i<n ; i++){
            String str = br.readLine();
            for(int j=0 ; j<m ; j++){
                board[i][j] = str.charAt(j);
            }
        }
        solution();
        br.close();
    }

    private static void solution(){
        int ret = Integer.MAX_VALUE;
        for(int i=0 ; i<=n-8 ; i++){
            for(int j=0 ; j<=m-8 ; j++){
                ret = Math.min(ret, check(i, j));
            }
        }
        System.out.println(ret);
    }

    private static int check(int y, int x){
        int case1 = 0, case2 = 0;

        final char[][] blackFirst = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        },
        whiteFirst = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        };

        for(int i=y ; i<y+8 ; i++){
            for(int j=x ; j<x+8 ; j++){
                if(board[i][j] != blackFirst[i-y][j-x])case1++;
                if(board[i][j] != whiteFirst[i-y][j-x])case2++;               
            }
        }
        return Math.min(case1, case2);
    }
}