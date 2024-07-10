import java.io.*;
import java.util.*;

class Main {

    private static int n, m;
    private static int[][] board;
    private static char[][] state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        int r = Integer.parseInt(tokenizer.nextToken());

        board = new int[n][m];
        state = new char[n][m];

        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=0 ; j<m ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
                state[i][j] = 'S';
            }
        }

        Map<Character, Integer> index = Map.of('E', 0, 'W', 1, 'S', 2, 'N', 3);
        int answer = 0;

        for(int i=0 ; i<r * 2 ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());

            if(i % 2 == 0){
                char dir = tokenizer.nextToken().charAt(0);
                answer += attackTurn(y - 1, x - 1, index.get(dir));
                continue;
            }

            state[y - 1][x - 1] = 'S';
        }
        bw.append(answer+"\n");
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                bw.append(state[i][j]).append(' ');
            }
            bw.append('\n');
        }
        bw.flush();
        bw.close();
    }

    private static int attackTurn(int y, int x, int dir){   
        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        int count = 0;

        int endY = y + board[y][x] * dy[dir], endX = x + board[y][x] * dx[dir];
        int mul = 0;

        while(true){
            int ny = y + mul * dy[dir], nx = x + mul * dx[dir];

            if(!isIn(ny, nx) || (ny == endY && nx == endX)) break;

            if(state[ny][nx] == 'S'){
                state[ny][nx] = 'F';
                count++;

                if(dy[dir] < 0 || dx[dir] < 0){
                    if(endY > board[ny][nx] * dy[dir] + ny 
                    || endX > board[ny][nx] * dx[dir] + nx){
                        endY = board[ny][nx] * dy[dir] + ny;
                        endX = board[ny][nx] * dx[dir] + nx;
                    }
                }

                else if(endY < board[ny][nx] * dy[dir] + ny 
                || endX < board[ny][nx] * dx[dir] + nx){
                    endY = board[ny][nx] * dy[dir] + ny;
                    endX = board[ny][nx] * dx[dir] + nx;
                }
            }

            mul++;
        }

        return count;
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}