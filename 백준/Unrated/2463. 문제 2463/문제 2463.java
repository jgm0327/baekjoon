import java.io.*;
import java.util.*;

class Main {
    static int n;
    static final int MOD = 1_000_000_000;
    static long total;
    static PriorityQueue<int[]> pq;
    static int[] parents;
    static long[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        parents = new int[n + 1];
        size = new long[n + 1];
        for(int i=0 ; i<=n ; i++){
            parents[i] = i;
            size[i] = 1;
        }

        pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int dist = Integer.parseInt(tokenizer.nextToken());

            total += dist;

            pq.add(new int[]{a, b, dist});
        }

        System.out.println(solution());

        br.close();
    }

    static long solution(){
        long ret = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int rootX = findParent(cur[0]);
            int rootY = findParent(cur[1]);

            if(rootX == rootY){
                total -= cur[2];
                continue;
            }

            long temp = (size[rootX] * size[rootY]) % MOD;
            ret = (ret + temp * total) % MOD;
            union(rootX, rootY);
            total -= cur[2];
        }

        return ret % MOD;
    }

    static int findParent(int x){
        if(x == parents[x])
            return x;

        return parents[x] = findParent(parents[x]);
    }
    
    static void union(int x, int y){
        int px = findParent(x), py = findParent(y);

        if(px == py)
            return;

        size[py] += size[px];

        parents[px] = py;
    }
}