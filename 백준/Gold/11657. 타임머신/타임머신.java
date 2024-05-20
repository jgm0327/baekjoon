import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        List<int[]> edges = new ArrayList<>();

        for(int i=0 ; i<m ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(tokenizer.nextToken()); 
            int des = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            edges.add(new int[]{sour, des, weight});
        }

        long[] costs = bellmanFord(n, m, edges);

        StringBuilder answer = new StringBuilder();
        
        for(int i=2 ; i<costs.length ; i++){

            answer
            .append(costs[i] == Integer.MAX_VALUE ? -1 : costs[i])
            .append("\n");
        }

        System.out.print(answer.length() > 0 ? answer : -1);
    }

    private static long[] bellmanFord(int n, int m, List<int[]> edges){
        long[] costs = new long[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[1] = 0;

        for(int i=0 ; i<n ; i++){
            for(int[] edge : edges){
                int sour = edge[0], des = edge[1], cost = edge[2];

                if(costs[sour] == Integer.MAX_VALUE || costs[des] <= costs[sour] + cost)
                    continue;
                
                if(i == n - 1)return new long[0];
                costs[des] = costs[sour] + cost;
            }
        }

        return costs;
    }
}
