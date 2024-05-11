import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    private static int n;
    private static double[][] stars;
    private static int[] parents;
    private static PriorityQueue<double[]> pq;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        stars = new double[n][2];
        parents = new int[n];

        for(int i=0 ; i<n ; i++){
            parents[i] = i;
        }

        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            double y = Double.parseDouble(tokenizer.nextToken());
            double x = Double.parseDouble(tokenizer.nextToken());

            stars[i] = new double[]{y, x};
        }

        pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[2] > o2[2])return 1;
            return -1;
        });

        for(int i=0 ; i<n ; i++){
            for(int j=i+1 ; j<n ; j++){
                double y = (stars[i][0] - stars[j][0]);
                double x = (stars[i][1] - stars[j][1]);
                double dist = Math.sqrt(y*y + x*x);

                pq.add(new double[]{i, j, dist});
            }
        }

        System.out.printf("%.2f", mst());
    }

    private static double mst(){
        double ret = 0.0;

        while(!pq.isEmpty()){
            double[] cur = pq.poll();
            int x = (int)cur[0], y = (int)cur[1];
            double dist = cur[2];

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