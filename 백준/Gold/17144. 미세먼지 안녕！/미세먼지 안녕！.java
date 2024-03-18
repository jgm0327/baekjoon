import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    private static int n, m;
    private static int[][] room;
    private static int[] airCleaner;
    private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        int t = Integer.parseInt(stk.nextToken());

        airCleaner = new int[2];
        room = new int[n][m];
        int idx = 0;

        for(int i=0 ; i<n ; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++){
                room[i][j] = Integer.parseInt(stk.nextToken());
                if(room[i][j] == -1)airCleaner[idx++] = i;
            }
        }

        while (t-- > 0) {
            diffusion();
            cleaner1();
            cleaner2();
        }

        int answer = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                answer += room[i][j];
            }
        }
        System.out.println((answer + 2));

    }

    private static int countAround(int[][] temp, int plus, int y, int x){
        int ret = 0;

        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];

            if(0 > ny || ny >= n || 0 > nx || nx >= m 
            || room[ny][nx] == -1)continue;
            temp[ny][nx] += plus;

            ret++;
        }

        return ret;
    }

    private static void diffusion(){
        int[][] temp = new int[n][m];

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(room[i][j] == -1 || room[i][j] == 0)continue;

                int minus = room[i][j] / 5;
                int ret = countAround(temp, minus, i, j);
                temp[i][j] -= minus * ret;
            }
        }

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(room[i][j] == -1)continue;
                room[i][j] += temp[i][j];
            }
        }
    }

    private static void cleaner1(){
        int airCleanerY = airCleaner[0];
        for(int i=airCleanerY - 1 ; i > 0 ; i--){
            room[i][0] = room[i-1][0];
        }

        for(int j=0 ; j < m - 1 ; j++){
            room[0][j] = room[0][j + 1];
        }

        for(int i=0 ; i<airCleanerY; i++){
            room[i][m - 1] = room[i + 1][m - 1];
        }

        for(int j=m - 1 ; j > 1 ; j--){
            room[airCleanerY][j] = room[airCleanerY][j - 1];
        }
        room[airCleanerY][1] = 0;
    }

    private static void cleaner2(){
        int airCleanerY = airCleaner[1];
        for(int i=airCleanerY + 1 ; i < n - 1 ; i++){
            room[i][0] = room[i+1][0];
        }

        for(int j=0; j < m - 1 ; j++){
            room[n - 1][j] = room[n - 1][j + 1];
        }

        for(int i=n - 1 ; i > airCleanerY - 1 ; i--){
            room[i][m - 1] = room[i - 1][m - 1];
        }

        for(int j=m - 1 ; j > 1 ; j--){
            room[airCleanerY][j] = room[airCleanerY][j - 1];
        }
        room[airCleanerY][1] = 0;
    }

}