import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    private static int n, m, k, answer;
    private static int[][] board, info, tempArray;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        board = new int[n + 1][m + 1];

        for(int i=1 ; i<=n ; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=m ; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        info = new int[k][3];
        for(int i=0 ; i<k ; i++){
            stk = new StringTokenizer(br.readLine());
            int r, c, s;
            r = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());
            s = Integer.parseInt(stk.nextToken());

            info[i] = new int[]{r, c, s};

            // for(int i=1 ; i<=n ; i++){
            //     for(int j=1 ; j<=m ; j++){
            //         System.out.print(board[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }

        answer = Integer.MAX_VALUE;
        visit = new boolean[k];
        dfs(0, new LinkedList<int[]>());

        System.out.println(answer);
    }

    private static int[][] deepCopy(){
        int[][] temp = new int[n + 1][m + 1];
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
                temp[i][j] = board[i][j];
            }
        }
        return temp;
    }

    private static int[][] rotateArray(int r, int c, int s){
        int temp = tempArray[r - s][c - s];

        for(int i=r - s ; i < r + s ; i++){
            tempArray[i][c - s] = tempArray[i + 1][c - s];
        }

        for(int j = c - s ; j < c + s ; j++){
            tempArray[r + s][j] = tempArray[r + s][j + 1];
        }

        for(int i=r+s ; i > r-s ; i--){
            tempArray[i][c + s] = tempArray[i - 1][c + s];
        }

        for(int j=c + s ; j > c - s ; j--){
            tempArray[r - s][j] = tempArray[r - s][j - 1];
        }

        tempArray[r-s][c-s+1] = temp;

        return tempArray;
    }

    private static void rotate(List<int[]> orders){
        for(int[] order : orders){
            int r = order[0], c = order[1], s = order[2];
            for(int i=s ; i>0 ; i--){
                rotateArray(r, c, i);
            }
        }

        calculateEachRow();
    }

    private static void dfs(int depth, LinkedList<int[]> orders){
        if(depth == k){
            tempArray = deepCopy();
            rotate(orders);
            return;
        }

        for(int i=0 ; i<k ; i++){
            if(visit[i])continue;
            orders.add(info[i]);
            visit[i] = true;
            dfs(depth + 1, orders);
            visit[i] = false;
            orders.pollLast();
        }
    }

    private static void calculateEachRow(){
        for(int i=1 ; i<=n ; i++){
            int max = 0;
            for(int j=1 ; j<=m ; j++){
                max += tempArray[i][j];
            }
            answer = Math.min(answer, max);
        }
    }
}