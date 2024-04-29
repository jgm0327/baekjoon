import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main{

    private static int n, answer;
    private static int[][] status;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        status = new int[n][n];

        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++){
                status[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        visit = new boolean[n];

        backtracking(0, 0);

        System.out.println(answer);
    }

    private static void backtracking(int depth, int start){
        if(depth == n / 2){
            answer = Math.min(answer, diff());
            return;
        }

        for(int i=start ; i<n ; i++){
            if(visit[i])continue;

            visit[i] = true;
            backtracking(depth + 1, i + 1);
            visit[i] = false;
        }
    }

    private static int diff(){

        int status1 = 0, status2 = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=1+i ; j<n ; j++){
                int total = (status[i][j] + status[j][i]);
                if(visit[i] && visit[j])status1 += total;
                else if(!visit[i] && !visit[j])status2 += total;
            }
        }
        return Math.abs(status1 - status2);
    }
}