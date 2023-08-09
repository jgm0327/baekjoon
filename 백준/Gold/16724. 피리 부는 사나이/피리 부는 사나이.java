import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

class Main{
    private static char[][] board;
    private static int n, m, answer;
    private static boolean[][] visit, finished;
    private static Map<Character, int[]> move;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        board = new char[n][m];
        for(int i=0 ; i<n ; i++){
            String values = br.readLine();
            for(int j=0 ; j<m ; j++){
                board[i][j] = values.charAt(j);
            }
        }

        visit = new boolean[n][m];
        finished = new boolean[n][m];
        move = Map.of('D', new int[]{1, 0}, 'U', new int[]{-1, 0}, 'L', new int[]{0, - 1}, 'R', new int[]{0, 1});

        answer = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(visit[i][j])continue;
                dfs(i, j);
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void dfs(int y, int x){
        visit[y][x] = true;
        int[] d = move.get(board[y][x]);
        int ny = y + d[0], nx = x + d[1];
        if(!visit[ny][nx])dfs(ny, nx);
        else if(!finished[ny][nx])answer++;
        finished[y][x] = true;
    }
}