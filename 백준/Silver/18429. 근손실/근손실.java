import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    private static int n, k, answer;
    private static int[] weights;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        weights = new int[n];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            weights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        visit = new boolean[n];

        dfs(0, 500);

        System.out.println(answer);

    }

    private static void dfs(int depth, int cur){
        if(depth == n){
            answer++;
            return;
        }

        for(int i=0 ; i<n ; i++){
            int next = cur + (weights[i] - k);
            
            if(visit[i] || next < 500)continue;
            
            visit[i] = true;
            dfs(depth + 1, next);
            visit[i] = false;
        }
    }

}