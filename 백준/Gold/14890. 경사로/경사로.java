import java.io.*;
import java.util.*;

class Main {

    private static int n, l;
    private static int[][] board;
    private static boolean[][] alreadyExist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        l = Integer.parseInt(tokenizer.nextToken());

        board = new int[n][n];

        alreadyExist = new boolean[n][n];
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=0 ; j<n ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // 행

        int answer = 0;

        for(int i=0 ; i<n ; i++){
            int x = 0;

            int prev = board[i][0];
            int len = 0;
            boolean canThroughWalk = true;

            while(x < n){
                if(prev == board[i][x]){
                    len++;
                }

                else if(board[i][x] == prev + 1){
                    if(len < l){
                        canThroughWalk = false;
                        break;
                    }

                    len = 1;
                    prev = board[i][x];
                }
                else if(board[i][x] + 1 == prev){
                    
                    len = 1;

                    while(x + 1 < n && board[i][x] == board[i][x + 1] && len < l){
                        len++;
                        x++;
                    }

                    // System.out.println(x + " " + len);

                    if(len < l){
                        canThroughWalk = false;
                        break;
                    }

                    prev = board[i][x];
                    len = 0;
                }
                else{
                    canThroughWalk = false;
                    break;
                }

                x++;
            }

            if(canThroughWalk){
                // System.out.println("y: " + i);
                answer++;
            }

            int y = 0;

            prev = board[0][i];
            len = 0;
            canThroughWalk = true;

            while(y < n){
                if(prev == board[y][i]){
                    len++;
                }

                else if(board[y][i] == prev + 1){
                    if(len < l){
                        canThroughWalk = false;
                        break;
                    }

                    len = 1;
                    prev = board[y][i];
                }
                else if(board[y][i] + 1 == prev){
                    
                    len = 1;

                    while(y + 1 < n && board[y][i] == board[y + 1][i] && len < l){
                        len++;
                        y++;
                    }

                    // System.out.println(x + " " + len);

                    if(len < l){
                        canThroughWalk = false;
                        break;
                    }

                    prev = board[y][i];
                    len = 0;
                }
                else{
                    canThroughWalk = false;
                    break;
                }

                y++;
            }

            if(canThroughWalk){
                // System.out.println("x: " + i);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

       
}