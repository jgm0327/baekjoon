import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    private static int n, h;
    private static int[] depth;
    private static int[][] dp;
    private static boolean[] visit;
    private static List<Integer>[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<n-1 ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        visit = new boolean[n + 1];
        h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
        dp = new int[n + 1][h];
        depth = new int[n + 1];
        
        makeTree(1, 1);

        for(int i=1 ; i<h ; i++){
            for(int j=1 ; j<=n ; j++){
                dp[j][i] = dp[dp[j][i - 1]][i - 1];
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while(m-- > 0){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            answer.append(LCA(a, b)).append("\n");
        }
        
        System.out.print(answer);
        
        br.close();
    }
    private static int LCA(int a, int b){
        if(depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        } 

        for (int i=h-1; i>=0; i--) {
            if(Math.pow(2, i) <= depth[a] - depth[b]){
                a = dp[a][i];
            }
        }

        if(a==b) return a;
        
        for(int i=h-1; i>=0; i--) {
            if(dp[a][i] != dp[b][i]) {
                a = dp[a][i];
                b = dp[b][i];
            }
        }

        return dp[a][0];
    }

    private static void makeTree(int parent, int d){
        visit[parent] = true;
        depth[parent] = d;

        for(int child : list[parent]){
            if(visit[child])
                continue;

            dp[child][0] = parent;
            makeTree(child, d + 1);
        }
    }
}