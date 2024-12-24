import java.io.*;
import java.util.*;

class Main {
    private static class CustomPath implements Comparable<CustomPath>{
        int sour, des;
        double dist;

        public CustomPath(int sour, int des, double dist){
            this.sour = sour;
            this.des = des;
            this.dist = dist;
        }

        @Override
        public int compareTo(CustomPath o){
            if(this.dist > o.dist)
                return 1;
            else if(this.dist < o.dist)
                return -1;
            return 0;
        }
    }
    
    // 1시6분 시작
    private static PriorityQueue<CustomPath> pq;
    private static int[] parents;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[][] point = new int[n + 1][2];
        for(int i=1 ; i<=n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());

            point[i] = new int[]{y, x};
        }

        pq = new PriorityQueue<>();
        for(int i=1 ; i<=n ; i++){
            for(int j=i+1 ; j<=n ; j++){
                pq.add(new CustomPath(i, j, calculateDist(point[i], point[j])));
            }
        }

        parents = new int[n + 1];
        for(int i=1 ; i<=n ; i++)
            parents[i] = i;

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());

            union(sour, des);
        }

        bw.write(String.format("%.2f", MST()));
        bw.close();
        br.close();
    }

    private static double MST(){
        double ret = 0;

        while(!pq.isEmpty()){
            CustomPath path = pq.poll();

            if(findParent(path.des) == findParent(path.sour))
                continue;

            ret += path.dist;
            union(path.sour, path.des);
        }

        return ret;
    }

    private static int findParent(int x){
        if(x == parents[x])
            return x;

        return parents[x] = findParent(parents[x]);
    }

    private static void union(int x, int y){
        int px = findParent(x);
        int py = findParent(y);

        if(px == py)
            return;

        parents[py] = px;
    }

    private static double calculateDist(int[] pos1, int[] pos2){
        long diffY = pos1[0] - pos2[0];
        long diffX = pos1[1] - pos2[1];

        return Math.sqrt(diffY * diffY + diffX * diffX);
    }
}