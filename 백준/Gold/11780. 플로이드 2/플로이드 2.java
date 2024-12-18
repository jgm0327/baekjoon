import java.io.*;
import java.util.*;

class Main {
    private static int n;
    private static int[][] costs, path;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int m =Integer.parseInt(br.readLine());

        costs = new int[n + 1][n + 1];
        for(int i=1;i<=n ;i++)
            Arrays.fill(costs[i], Integer.MAX_VALUE);

        
        path = new int[n + 1][n + 1];
        while(m-- > 0){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());
            int cost = Integer.parseInt(tokenizer.nextToken());

            costs[sour][des] = Math.min(costs[sour][des], cost);

            path[sour][des] = des;
        }

        floyd();
        StringBuilder answer = new StringBuilder();
        for(int i=1 ; i<=n ; i++){
            for(int j=1; j<=n ; j++){
                if(costs[i][j] == Integer.MAX_VALUE)
                    costs[i][j] = 0;

                answer.append(costs[i][j]).append(" ");
            }
            answer.append('\n');
        }
        
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                StringBuilder p = new StringBuilder();
                int count = dfs(i, path[i][j], j, p);
                if(count == 1)
                    answer.append("0\n");
                else
                    answer.append(count).append(' ').append(p);
            }
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }

    private static int dfs(int sour, int des, int end, StringBuilder p){
        if(sour == end || path[sour][end] == 0){
            p.append(end).append('\n');
            return 1;
        }

        int next = path[sour][end];

        p.append(sour).append(' ');
        return dfs(path[sour][next], sour, end, p) + 1;
    }

    private static void floyd(){
        for(int k=1 ; k<=n ; k++){
            for(int i=1 ; i<=n ; i++){
                for(int j=1 ; j<=n ; j++){
                    if(costs[i][k] == Integer.MAX_VALUE || costs[k][j] == Integer.MAX_VALUE || i == j)
                        continue;
                    
                    if(costs[i][j] > costs[i][k] + costs[k][j]){
                        path[i][j] = path[i][k];
                        costs[i][j] = costs[i][k] + costs[k][j];
                    }
                }
            }
        }
    }
}