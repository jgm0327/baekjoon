import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int[] parents, count, total, candies;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        candies = new int[n + 1];
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            candies[i] = Integer.parseInt(tokenizer.nextToken());
            count[i] = 1;
        }

        parents = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parents[i] = i;

        while (m-- > 0) {
            tokenizer = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());

            union(sour, des);
        }

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});

        for (int i = 1; i <= n; i++) {
            if (i != parents[i])
                continue;

            list.add(new int[]{count[i], candies[i]});
        }

        int[][] dp = new int[list.size()][k];
        for(int i=1 ; i<list.size() ; i++){
            int c = list.get(i)[0], v = list.get(i)[1];
            for(int j=1 ; j<k ; j++){
                if(c > j){
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c] + v);
            }
        }

        System.out.println(dp[list.size() - 1][k - 1]);

        br.close();
    }

    static int findParent(int x) {
        if (x == parents[x])
            return x;

        return parents[x] = findParent(parents[x]);
    }

    static void union(int x, int y) {
        int px = findParent(x), py = findParent(y);

        if (px == py)
            return;

        count[py] += count[px];
        parents[px] = py;
        candies[py] += candies[px];
        candies[px] = 0;
    }

}