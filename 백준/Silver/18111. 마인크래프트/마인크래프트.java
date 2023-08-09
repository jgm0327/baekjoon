import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    private static int[][] board;
    private static int n, m, b, max, min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());

        board = new int[n][m];
        max = 0;
        min = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
                min = Math.min(board[i][j], min);
                max = Math.max(board[i][j], max);
            }
        }

        int answer = Integer.MAX_VALUE, height = 0;
        
        for(int h = max ; h >= min ; h--){
            int time = 0, total = b;
            for(int i=0 ; i<n; i++){
                for(int j=0 ; j<m ; j++){
                    if(h > board[i][j]){
                        time += (h - board[i][j]);
                        total -= (h - board[i][j]);
                    }else if(h < board[i][j]){
                        time += 2 * (board[i][j] - h);
                        total += (board[i][j] - h);
                    }
                }
            }
            if(total >=0  && answer > time){
                answer = time;
                height = h;
            }
        }

        System.out.println(answer + " " + height);
        br.close();
    }
}