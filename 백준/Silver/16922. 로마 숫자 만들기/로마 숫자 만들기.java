import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main{
    private static boolean[][] visit;
    private static int answer = 0;
    private static final int[] number = {1, 5, 10, 50};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        visit = new boolean[n][50 * 20 + 1];

        dfs(0, n, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int end, int total){
        if(depth == end){
            answer++;
            return;
        }

        for(int i=0 ; i<4 ; i++){
            int nextTotal = total + number[i];

            if(visit[depth][nextTotal])continue;
            
            visit[depth][nextTotal] = true;
            dfs(depth + 1, end, nextTotal);
        }
    }

}