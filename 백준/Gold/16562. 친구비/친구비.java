import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main{
    private static int n, money;
    private static int[] parents, costs;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        money = Integer.parseInt(tokenizer.nextToken());
        
        parents = new int[n + 1];
        costs = new int[n + 1];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++){
            parents[i] = i;
            costs[i] = Integer.parseInt(tokenizer.nextToken());
        }

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());
            int x, y;

            x = Integer.parseInt(tokenizer.nextToken());
            y = Integer.parseInt(tokenizer.nextToken());

            union(x, y);
        }

        Map<Integer, Boolean> visit = new HashMap<>();
        long answer = 0;
        for(int i=1 ; i<=n ; i++){
            int px = findParent(parents[i]);
            if(visit.containsKey(px))
                continue;

            answer += costs[px];
            visit.put(px, true);
        }

        System.out.println(answer == 0 || answer > money ? "Oh no" : answer);
    }
    
    private static int findParent(int x){
        if(x == parents[x])
            return x;
        return parents[x] = findParent(parents[x]);
    }

    private static void union(int x, int y){
        int px = findParent(x), py = findParent(y);

        if(px == py)
            return;

        if(costs[py] < costs[px]){
            int temp = py;
            py = px;
            px = temp;
        }

        parents[py] = px;
    }

}