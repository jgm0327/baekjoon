import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main{

    private static int n, m;
    private static int[][] map;
    private static final int[] dy = {0, 0,-1,-1,-1,0,1,1,1}, dx = {0, -1,-1,0,1,1,1,0,-1};
    private static ArrayDeque<int[]> clouds;
    private static boolean[][] disappeared;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        map = new int[n + 1][n + 1];
        for(int i=1 ; i<=n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=n ; j++){
                map[i][j] = Integer.parseInt(tokenizer.nextToken());   
            }
        }

        clouds = new ArrayDeque<>();
        clouds.add(new int[]{n, 1});
        clouds.add(new int[]{n, 2});
        clouds.add(new int[]{n - 1, 1});
        clouds.add(new int[]{n - 1, 2});
        

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(tokenizer.nextToken());
            int s = Integer.parseInt(tokenizer.nextToken());

            disappeared = new boolean[n + 1][n + 1];

            moveClouds(d, s);
            copyWater();
            makeCloud();
        }

        int answer = 0;

        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                answer += map[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void moveClouds(int d, int s){
        int size = clouds.size();

        while(size-- > 0){
            int[] pos = clouds.poll();
            int y = pos[0], x = pos[1];

            int ny = calculatePosition(y, dy[d] * s);
            int nx = calculatePosition(x, dx[d] * s);

            if(disappeared[ny][nx])
                continue;

            map[ny][nx]++;
            clouds.add(new int[]{ny, nx});
            disappeared[ny][nx] = true;
        }
    }
    
    private static int calculatePosition(int p, int dist){
        if(dist == 0)
            return p;

        int np = p + dist;

        if(np > 0 && np % n == 0){
            return n;
        }
        if(np > 0){
            return (np % n);
        }

        return n + (np % n);
    }

    private static void copyWater(){
        while(!clouds.isEmpty()){
            int[] cloud = clouds.poll();
            int y = cloud[0], x = cloud[1];

            int ret = 0;

            for(int i=2 ; i<=8 ; i += 2){
                int ny = y + dy[i], nx = x + dx[i];

                if(1 > ny || ny > n || 1 > nx || nx > n || map[ny][nx] == 0)
                    continue;

                ret++;
            }

            map[y][x] += ret;
        }
    }

    private static void makeCloud(){
        for(int y=1 ; y<=n ; y++){
            for(int x=1 ; x<=n ; x++){
                if(disappeared[y][x] || map[y][x] < 2)
                    continue;

                map[y][x] -= 2; 
                clouds.add(new int[]{y, x});
            }
        }
    }
}