import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    private static int n;
    private static int[] parents;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        
        parents = new int[n + 1];
        for(int i=1 ; i<=n ; i++){
            parents[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());
            int sour, des, weight;

            sour = Integer.parseInt(tokenizer.nextToken());
            des = Integer.parseInt(tokenizer.nextToken());
            weight = Integer.parseInt(tokenizer.nextToken());

            pq.add(new int[]{sour, des, weight});
        }

        System.out.println(mst(pq));
    }

    private static int mst(PriorityQueue<int[]> pq){   
        int ret = 0;

        int temp = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], weight = cur[2];

            if(findParent(x) == findParent(y))
                continue;
            
            union(x, y);
            temp = weight;
            ret += weight;
        }

        return ret - temp;
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

        parents[py] = px;
    }

}