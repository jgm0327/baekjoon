import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] ladder;
    private static int n, m, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        h = Integer.parseInt(stk.nextToken());

        ladder = new int[h + 1][n + 1][n + 1];

        for(int i=0 ; i<m ; i++){
            stk = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            ladder[a][b][b + 1] = 1;
            ladder[a][b + 1][b] = 1;
        }

        for(int i=0 ; i<=3 ; i++)
            dfs(0, i);

        System.out.println(-1);
    }

    private static void dfs(int depth, int cnt){
        if(depth == cnt){
            if(check()){
                System.out.println(cnt);
                System.exit(0);
            }
            return;
        }

        for(int i=1 ; i<=h ; i++){
            for(int j=1 ; j<n ; j++){
                if(ladder[i][j][j+1] == 1 || ladder[i][j][j-1] == 1)
                    continue;
                
                    ladder[i][j][j+1] = 1;
                    ladder[i][j+1][j] = 1;

                    dfs(depth + 1, cnt);

                    ladder[i][j][j+1] = 0;
                    ladder[i][j+1][j] = 0;
            }
        }
    }

    private static boolean check(){
        for(int i=1 ; i<=n ; i++){
            int curPosition = i;
            for(int y = 1 ; y <= h ; y++){
                if(curPosition + 1 <= n && ladder[y][curPosition][curPosition + 1] == 1)
                    curPosition++;
                else if(curPosition - 1 >= 1 && ladder[y][curPosition][curPosition - 1] == 1)
                    curPosition--;
            }

            if(curPosition != i)
                return false;
        }

        return true;
    }
}
