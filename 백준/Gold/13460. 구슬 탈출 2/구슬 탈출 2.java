import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main{

    private static int n, m, answer;
    private static char[][] board;
    private static int[] hole;
    private static ArrayDeque<int[]> redMarble, blueMarble;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        board = new char[n][m];
        blueMarble = new ArrayDeque<>();
        redMarble = new ArrayDeque<>();

        for(int i=0 ; i<n ; i++){
            String input = br.readLine();
            for(int j=0 ; j<m ; j++){
                board[i][j] = input.charAt(j);
                if(board[i][j] == 'R')redMarble.add(new int[] {i, j, 0});
                else if(board[i][j] == 'B')blueMarble.add(new int[] {i, j, 0});
                else if(board[i][j] == 'O')hole = new int[] {i, j};
            }
        }

        answer = Integer.MAX_VALUE;
        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void bfs(){
        boolean[][][][] visit = new boolean[n][m][n][m];

        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};

        visit[redMarble.peek()[0]][redMarble.peek()[1]][blueMarble.peek()[0]][blueMarble.peek()[1]] = true;

        // 벽만 표시하기 위해서
        board[redMarble.peek()[0]][redMarble.peek()[1]] = '.';
        board[redMarble.peek()[0]][redMarble.peek()[1]] = '.';

        while(!redMarble.isEmpty() && !blueMarble.isEmpty()){

            
            int[] red = redMarble.poll();
            int[] blue = blueMarble.poll();

            for(int i=0 ; i<4 ; i++){
                int nry = red[0] * dy[i], nrx = red[1] * dx[i];
                int nby = blue[0] * dy[i], nbx = blue[1] * dx[i];
                int[] nextRed, nextBlue;

                // 상하좌우로 움직일 때 먼저 움직여야 하는 구슬 정하기
                if(nry > nby || nrx > nbx){
                    nextRed = nextPosition(red[0], red[1], blue[0], blue[1], dy[i], dx[i]);
                    nextBlue = nextPosition(blue[0], blue[1], nextRed[0], nextRed[1], dy[i], dx[i]);
                }else{
                    nextBlue = nextPosition(blue[0], blue[1], red[0], red[1], dy[i], dx[i]);
                    nextRed = nextPosition(red[0], red[1], nextBlue[0], nextBlue[1], dy[i], dx[i]);
                }

                // 파란 구슬이 구멍을 빠져나가면 안됨
                if(nextBlue[0] == hole[0] && nextBlue[1] == hole[1]){
                    continue;
                }

                if(nextRed[0] == hole[0] && nextRed[1] == hole[1]){
                    // 빨간 구슬이 구멍을 나가고 파란 구슬도 구멍을 빠져나가는지 확인
                    nextBlue = nextPosition(nextBlue[0], nextBlue[1], -1, -1, dy[i], dx[i]);

                    // 나갔다면 출력 X
                    if(nextBlue[0] == hole[0] && nextBlue[1] == hole[1])
                        continue;

                    answer = Math.min(answer, red[2] + 1);
                    continue;
                }
                
                // 두 구슬이 위치한 칸 들이 같을 경우 혹은 10번 이상 동안 못 나간 경우 continue
            if(visit[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] || red[2] + 1 == 10)
                continue;

                visit[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;

                redMarble.add(new int[]{nextRed[0], nextRed[1], red[2] + 1});
                blueMarble.add(new int[]{nextBlue[0], nextBlue[1], blue[2] + 1});
            }
        }
    }

    private static int[] nextPosition(int y, int x, int marbleY, int marbleX, int dy, int dx){
        int[] ret = {y, x};

        int prevY = y, prevX = x;

        for(int i=1 ; i<=Math.max(n, m) ; i++){
            int ny = y + dy * i, nx = x + dx * i;

            if(ny == hole[0] && nx == hole[1]){
                return new int[]{ny, nx};
            }

            if(board[ny][nx] == '#' || (marbleY == ny && marbleX == nx)){
                return new int[]{prevY, prevX};
            }

            prevY = ny;
            prevX = nx;
        }   

        return ret;
    }
}