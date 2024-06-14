import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{

    static class FireBall{
        int y, x, mass, speed, odd, even, count;
        List<Integer> direction;

        public FireBall(){
            this.y = 0;
            this.x = 0;
            this.mass = 0;
            this.speed = 0;
            this.direction = new ArrayList<>();
            this.odd = 0;
            this.even = 0;
            this.count = 0;
        }

        public void updateDirection(int d){
            if(d % 2 == 0)even++;
            else odd++;
        }

        public void splitFireBall(){
            if(this.count == 1)
                return;

            this.mass = this.mass / 5;
            this.speed = this.speed / this.count;

            direction = new ArrayList<>();
            if(odd == count || even == count){
                direction.add(0);
                direction.add(2);
                direction.add(4);
                direction.add(6);
            }
            else{
                direction.add(1);
                direction.add(3);
                direction.add(5);
                direction.add(7);
            }
        }

        @Override
        public String toString(){
            return "(" + mass + ", " + count + ", " + speed + ", " + direction + ")";
        }
    }

    private static int n;
    private static FireBall[][] board;
    private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1, 0}, dx = {0,1,1,1,0,-1,-1,-1, 0};
    private static Queue<int[]> fireBallPosition;
    private static boolean[][] visit;
    private static List<int[]> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        board = createBoard();
        fireBallPosition = new LinkedList<>();

        for(int i=0 ; i<m ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());

            board[y][x].count = 1;
            board[y][x].mass = Integer.parseInt(tokenizer.nextToken());
            board[y][x].speed = Integer.parseInt(tokenizer.nextToken());
            board[y][x].direction.add(Integer.parseInt(tokenizer.nextToken()));
            board[y][x].updateDirection(board[y][x].direction.get(0));

            fireBallPosition.add(new int[]{y, x});
        }
        
        while(k-- > 0){
            visit = new boolean[n + 1][n + 1];
            list = new ArrayList<>();

            moveFireBalls();

            for(int[] pos : list){
                int y = pos[0], x = pos[1];
                board[y][x].splitFireBall();
            }
        }

        long answer = 0;
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                answer += board[i][j].mass * board[i][j].direction.size();
            }
        }

        System.out.println(answer);
    }

    private static FireBall[][] createBoard(){
        FireBall[][] temp = new FireBall[n + 1][n + 1];
        
        for(int i=0 ; i<=n ; i++){
            temp[i] = new FireBall[n + 1];
            for(int j=0 ; j<=n ; j++){
                temp[i][j] = new FireBall();
            }
        }

        return temp;
    }

    private static void moveFireBalls(){
        int size = fireBallPosition.size();

        FireBall[][] tempBoard = createBoard();

        for(int i=0 ; i<size; i++){
            int[] cur = fireBallPosition.poll();

            int y = cur[0], x = cur[1];

            if(board[y][x].mass == 0 || board[y][x].count == 0)
                continue;

            if(board[y][x].count <= 1){
                moveFireBall(y, x, board[y][x].direction.get(0), tempBoard);
                continue;
            }

            for(int d : board[y][x].direction){
                moveFireBall(y, x, d, tempBoard);
            }
        }

        board = tempBoard;
    }
    
    private static void moveFireBall(int y, int x, int d, FireBall[][] tempBoard){
        FireBall fireBall = board[y][x];

        int ny = move(y, dy[d] * fireBall.speed), nx = move(x, dx[d] * fireBall.speed);

        tempBoard[ny][nx].mass += fireBall.mass;
        tempBoard[ny][nx].speed += fireBall.speed;
        tempBoard[ny][nx].updateDirection(d);
        tempBoard[ny][nx].count++;
        tempBoard[ny][nx].direction.add(d);

        if(visit[ny][nx])
            return;

        visit[ny][nx] = true;
        fireBallPosition.add(new int[]{ny, nx});
        list.add(new int[]{ny, nx});
    }

    private static int move(int pos, int dt){
        if(dt == 0)
            return pos;

        int ret = pos + dt;

        if(1 <= ret && ret <= n)
            return ret;

        if(ret > 0 && ret % n == 0)ret = n;
        else if(ret > 0)ret = (ret % n);
        else ret = n + (ret % n);

        return ret;
    }
}