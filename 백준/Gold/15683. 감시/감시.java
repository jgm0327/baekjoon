import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    private static int n, m, answer;
    private static int[][] map;
    private static List<int[]> cctvPositions;
    private static int[][][] dirY = 
    {{}, 
    {{0}, {1}, {0}, {-1}},
    {{0, 0}, {1, -1}}, 
    {{1}, {-1}, {-1}, {1}}, 
    {{1, 0}, {1, -1}, {-1, 0}, {1, -1}}, 
    {{1, -1}}},
    dirX = {
        {},
        {{1}, {0}, {-1}, {0}},
        {{1, -1}, {0, 0}}, 
        {{1}, {1}, {-1}, {-1}}, 
        {{1, -1}, {1, 0}, {1, -1}, {-1, 0}}, 
        {{1, -1}}};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        cctvPositions = new ArrayList<>();
        map = new int[n][m];

        int space = 0;
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ;j++){
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
                if(1 <= map[i][j] && map[i][j] <= 5)cctvPositions.add(new int[]{i, j});
                else if(map[i][j] == 0) space++;
            }
        }

        answer = space;
        backtracking(0, space, new ArrayDeque<>());
        System.out.println(answer);
    }

    private static void backtracking(int depth, final int total, ArrayDeque<Integer> dir) {
        if(depth == cctvPositions.size()){
            answer = Math.min(answer, check(dir, total));
            return;
        }

        int[] cur = cctvPositions.get(depth);
        int y = cur[0], x = cur[1];
        int number = map[y][x];

        for(int i=0 ; i<dirY[number].length; i++){
            dir.add(i);
            backtracking(depth + 1, total, dir);
            dir.removeLast();
        }
    }

    private static int check(ArrayDeque<Integer> dir, final int total){
        int ret = 0, idx = 0;

        boolean[][] visit = new boolean[n][m];

        for(int d : dir){
            int[] cctv = cctvPositions.get(idx++);
            int y = cctv[0], x = cctv[1];
            int number = map[y][x];

            int[] dy = dirY[number][d], dx = dirX[number][d];
            
            for(int i=0 ; i<dy.length ; i++){
                for(int j=1 ; j<n ; j++) {
                    int ny = y + dy[i] * j;
                    if(dy[i] == 0 || ny < 0 || ny >= n || map[ny][x] == 6)break;
                    if(visit[ny][x] || map[ny][x] != 0)continue;
                    ret++;
                    visit[ny][x] = true;
                }

                for(int j=1 ; j<m ; j++){
                    int nx = x + dx[i] * j;
                    if(dx[i] == 0 || nx < 0 || nx >= m || map[y][nx] == 6)break;
                    if(visit[y][nx] || map[y][nx] != 0)continue;
                    ret++;
                    visit[y][nx] = true;
                }
            }

        }

        return total - ret;
    }

}