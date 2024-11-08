import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        int total = 0;
        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for(int j=0 ; j<n ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
                total += board[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int y = 0 ; y < n ; y++){
            for(int x = 0 ; x < n ; x++){
                for(int d1 = 1 ; d1 < n ; d1++){
                    for(int d2 = 1 ; d2 < n ; d2++){
                        answer = Math.min(answer, getMinDiff(board, y, x, d1, d2, total, n));
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static int getMinDiff(final int[][] board, int y, int x, int d1, int d2, int total, int n){
        if(y + d1 >= n || y + d2 >= n || y + d1 + d2 >= n
        || x - d1 < 0 || x + d2 >= n || x-d1+d2 >= n || x+d2-d1 >= n
        || x+d2-d1 < 0)
            return Integer.MAX_VALUE;

        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        boolean[][] walls = setWall(board, y, x, d1, d2, n);

        int sum = 0;
        for(int i=0 ; i<y+d1 ; i++){
            for(int j=0 ; j<=x ; j++){
                if(walls[i][j])
                    break;

                sum += board[i][j];
            }
        }

        if(sum == 0)
            return Integer.MAX_VALUE;

        total -= sum;
        maxValue = Math.max(maxValue, sum);
        minValue = Math.min(minValue, sum);

        sum = 0;
        for(int i=0 ; i<=y+d2 ; i++){
            for(int j=n-1 ; j>x ; j--){
                if(walls[i][j])
                    break;

                sum += board[i][j];
            }
        }
        
        if(sum == 0)
            return Integer.MAX_VALUE;
            
        total -= sum;
        maxValue = Math.max(maxValue, sum);
        minValue = Math.min(minValue, sum);

        sum = 0;
        for(int i=y+d1 ; i<n ; i++){
            for(int j=0 ; j<x-d1+d2 ; j++){
                if(walls[i][j])
                    break;

                sum += board[i][j];
            }
        }
        
        if(sum == 0)
            return Integer.MAX_VALUE;
            
        total -= sum;
        maxValue = Math.max(maxValue, sum);
        minValue = Math.min(minValue, sum);

        sum = 0;
        for(int i=y+d2+1 ; i<n ; i++){
            for(int j=n-1 ; j>=x-d1+d2 ; j--){
                if(walls[i][j])
                    break;
                sum += board[i][j];
            }
        }
        
        if(sum == 0)
            return Integer.MAX_VALUE;
            
        total -= sum;
        maxValue = Math.max(maxValue, sum);
        minValue = Math.min(minValue, sum);

        // System.out.println(total);
        maxValue = Math.max(maxValue, total);
        minValue = Math.min(minValue, total);
        // System.out.println("ret: " + (maxValue - minValue));
        // System.out.println();

        return maxValue - minValue;
    }

    private static boolean[][] setWall(int[][] board, int y, int x, int d1, int d2, int n){
        boolean[][] wall = new boolean[n][n];

        for(int i=0 ; i<=d1 ; i++){
            wall[y+i][x-i] = true;
            wall[y+d2+i][x+d2-i] = true;
        }

        for(int i=0 ; i<=d2 ; i++){
            wall[y+i][x+i] = true;
            wall[y+d1+i][x-d1+i] = true;
        }

        return wall;
    }
}