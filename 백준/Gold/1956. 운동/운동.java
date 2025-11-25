import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[][] costs;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        costs = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            Arrays.fill(costs[i], Integer.MAX_VALUE);

        while (m-- > 0) {
            tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            costs[a][b] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if(costs[i][k] == Integer.MAX_VALUE)
                    continue;
                for (int j = 1; j <= n; j++) {
                    if(costs[k][j] == Integer.MAX_VALUE)
                        continue;

                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++){
                if(costs[i][j] == Integer.MAX_VALUE || costs[j][i] == Integer.MAX_VALUE)
                    continue;

                answer = Math.min(answer, costs[i][j] + costs[j][i]);
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

        br.close();
    }
}