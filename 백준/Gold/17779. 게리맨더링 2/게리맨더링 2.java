import java.io.*;
import java.util.*;

class Main {

    private static int n, answer, total;
    private static int[][] board;
    private static boolean[][] isLine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        board = new int[n + 1][n + 1];

        for(int i=1 ; i<=n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=n ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
                total += board[i][j];
            }
        }

        // System.out.println(total);

        answer = Integer.MAX_VALUE;

        for(int y=1 ; y<=n ; y++){
            for(int x=1 ; x<=n ; x++){
                solution(y, x);
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static void solution(int y, int x){
        for(int d1=1 ; d1<=n ; d1++){
            for(int d2=1 ; d2<=n ; d2++){
                if(!isIn(y-d1, x+d1) || !isIn(y+d2, x+d2) || !isIn(y-d1+d2, x+d1+d2) || !isIn(y+d1-d2, x+d1+d2))
                    continue;

                isLine = new boolean[n + 1][n + 1];
                answer = Math.min(answer, getMinDiff(y, x, d1, d2));
            }
        }
    }

    private static boolean isIn(int y, int x){
        return 1<=y && y<=n && 1<=x && x<=n;
    }

    private static int getMinDiff(int y, int x, int d1, int d2){
        int[] sum = new int[5];
        int remain = 0;

        setLine(y, x, d1, d2);

        //1
        for(int i=1 ; i<y ; i++){
            for(int j=1 ; j<=x+d1;j++){
                if(isLine[i][j])
                    break;

                sum[0] += board[i][j];
            }
        }
        remain += sum[0];

        //2
        for(int i=1 ; i<=y+d2-d1 ; i++){
            for(int j=n ; j>x+d1 ;j--){
                if(isLine[i][j])
                    break;

                // print(y, x, d1, d2, i, j, 0);
                sum[1] += board[i][j];
            }
        }
        // print(y, x, d1, d2, -1, -1, sum[1]);
        remain += sum[1];

        //3
        for(int i=y ; i<=n ; i++){
            for(int j=1 ; j<x+d2 ; j++){
                if(isLine[i][j])
                    break;

                sum[2] += board[i][j];
            }
        }
        remain += sum[2];

        //4
        for(int i=y-d1+d2+1 ; i<=n ; i++){
            for(int j=n ; j>=x+d2 ;j--){
                if(isLine[i][j])
                    break;
                
                sum[3] += board[i][j];
                // print(y, x, d1, d2, i, j, 0);
            }
        }
        remain += sum[3];

        //5
        sum[4] = total - remain;

        Arrays.sort(sum);

        // System.out.println(y + " " + x + " " + d1 + " " +d2);
        // System.out.println(sum[0] + " " + sum[1] + " " + sum[2] + " " + sum[3] + " " + sum[4]);
        // System.out.println();

        return sum[4] - sum[0];
    }

    private static void print(int y, int x, int d1, int d2, int i, int j, int sum){
        if(y != 5 || x != 3 || d1 != 2 || d2 != 1)  
            return;

        System.out.println(i + " " + j);
        System.out.println(sum);
    }

    private static void setLine(int y, int x, int d1, int d2){
        for(int i=0 ; i<=d1 ; i++){
            isLine[y-i][x+i] = true;
        }

        for(int i=0 ; i<=d2 ; i++){
            isLine[y+i][x+i] = true;
        }

        for(int i=0 ; i<=d2 ; i++){
            isLine[y-d1+i][x+d1+i] = true;
        }

        for(int i=0 ; i<=d1 ; i++){
            isLine[y+d2-i][x+d2+i] = true;
        }
    }
}