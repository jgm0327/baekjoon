import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    private static int n;
    private static int[] parents;
    private static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        parents = new int[n];

        pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for(int i=0 ; i<n ; i++){
            parents[i] = i;
        }

        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++){
                pq.add(new int[]{i, j, Integer.parseInt(tokenizer.nextToken())});
            }
        }

        System.out.println(mst());
    }

    private static long mst(){
        long ret = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if(findParent(x) == findParent(y))
                continue;

            ret += dist;
            union(x, y);
        }

        return ret;
    }

    private static int findParent(int x){
        if(parents[x] == x)return x;
        return parents[x] = findParent(parents[x]);
    }

    private static void union(int y, int x){
        int px = findParent(x), py = findParent(y);

        if(px == py)return;

        parents[py] = px;
    }

}