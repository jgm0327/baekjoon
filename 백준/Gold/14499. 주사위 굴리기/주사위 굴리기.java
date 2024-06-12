import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    // 동쪽 1 -> 4 -> 6 -> 3 -> 1
    // 서쪽 1 -> 3 -> 6 -> 4 -> 1
    // 북쪽 1 -> 2 -> 5 -> 6 -> 1
    // 남쪽 1 -> 6 -> 5 -> 2 -> 1

    private static int[] dice;
    private static int[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int y = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());

        int k = Integer.parseInt(tokenizer.nextToken());


        board = new int[n][m];
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        
        tokenizer = new StringTokenizer(br.readLine());
        dice = new int[7];
        StringBuilder answer = new StringBuilder();

        final int[] dy = {0, 0, 0, -1, 1}, dx = {0, 1, -1, 0, 0};
        while(k-- > 0){
            int order = Integer.parseInt(tokenizer.nextToken());

            int ny = y + dy[order], nx = x + dx[order];
            
            if(0 > ny || ny >= n || 0 > nx || nx >= m)
                continue;

            rollingDice(order);

            y = ny;
            x = nx;

            if(board[ny][nx] != 0){
                dice[6] = board[ny][nx];
                board[ny][nx] = 0;
            }
            else{
                board[ny][nx] = dice[6];
            }

            answer.append(dice[1]).append("\n");
        }

        System.out.print(answer);
    }

    private static void rollingDice(int d){
        if(d == 1){
            right();
            return;
        }

        if(d == 2){
            left();
            return;
        }

        if(d == 3){
            up();
            return;
        }

        down();
    }

    private static void right(){
        int t1 = dice[1];

        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = t1;
    }

    private static void left(){
        int t6 = dice[6];
        
        dice[6] = dice[4];
        dice[4] = dice[1];
        dice[1] = dice[3];
        dice[3] = t6;
    }

    private static void up(){
        int t1 = dice[1];
        
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = dice[2];
        dice[2] = t1;
    }

    private static void down(){
        int t1 = dice[1];

        dice[1] = dice[2];
        dice[2] = dice[6];
        dice[6] = dice[5];
        dice[5] = t1;
    }
}