import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main{
    private static int n, answer = Integer.MAX_VALUE;
    private static int[][] scores;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        scores = new int[n][n];

        for(int i=0 ; i<n ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++){
                scores[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        divideTeam(0, 0);
        System.out.println(answer);
        br.close();
    }

    private static void divideTeam(int start, int depth){
        if(depth == n){
            return;
        }

        for(int i=start ; i<n ; i++){
            if(visit[i])continue;
            getDiff();
            visit[i] = true;
            divideTeam(i + 1, depth + 1);
            visit[i] = false;
        }      
    }

    private static void getDiff(){
        int total1 = 0, total2 = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int sum = (scores[i][j] + scores[j][i]);
                if(visit[i] && visit[j]){
                    total1 += sum;
                }else if(!visit[i] && !visit[j]){
                    total2 += sum;
                }
            }
        }
        answer = Math.min(answer, Math.abs(total1 - total2));
    }
}