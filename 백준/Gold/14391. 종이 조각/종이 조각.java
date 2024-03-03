import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int n, m, answer, endY, endX;
    private static char[][] board;
    private static List<int[]> range;
    private static boolean[] visit;
    private static List<int[]> sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] boardSize = br.readLine().split(" ");

        n = Integer.parseInt(boardSize[0]);
        m = Integer.parseInt(boardSize[1]);

        range = new ArrayList<>();

        for(int j=0 ; j<m ; j++){
            for(int size = 1 ; size <= n ; size++){
                for(int i=0; i<n ; i++){
                    if(i + size - 1 >= n)continue;
                    range.add(new int[]{i, j, i + size - 1, j});
                }
            }
        }

        for(int i=0 ; i<n ; i++){
            for(int size = 2 ; size<= m ; size++){
                for(int j=0 ; j<m ; j++){
                    if(j + size - 1 >= m)continue;
                    range.add(new int[]{i, j, i, j + size - 1});
                }
            }
        }

        board = new char[n][m];

        for(int i=0 ; i<n ; i++){
            String values = br.readLine();
            endY |= (1 << i);
            for(int j=0 ; j<m ; j++){
                board[i][j] = values.charAt(j);
                endX |= (1 << j);
            }
        }

        sum = new ArrayList<>();
        
        for(int[] pos : range){
            StringBuilder total = new StringBuilder();
            for(int i = pos[0] ; i <= pos[2] ; i++){
                for(int j = pos[1] ; j <= pos[3] ; j++){
                    total.append(board[i][j]);
                }
            }
            int y = 0;
            for(int i=pos[0]; i<=pos[2] ; i++)y |= ((1 << i));
            int x = 0;
            for(int i=pos[1] ; i<=pos[3] ; i++)x |= ((1 << i));

            sum.add(new int[]{Integer.parseInt(total.toString()), y, x});
        }

        answer = 0;
        visit = new boolean[sum.size()];
        dfs(0, 0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int total, int curY, int curX){
        
        if(curX == endX && curY == endY){
            answer = Math.max(answer, total);
            return;
        }

        for(int i=0 ; i<sum.size() ; i++){
            int s = sum.get(i)[0], y = sum.get(i)[1], x = sum.get(i)[2];

            if(visit[i] || ((curY & y) != 0 && (curX & x) != 0))continue;

            visit[i] = true;
            dfs(i + 1, total + s, curY | y, curX | x);
            visit[i] = false;
        }
    }
}

