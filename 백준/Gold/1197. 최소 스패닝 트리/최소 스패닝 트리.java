import java.io.*;
import java.util.*;

class Main {
    private static int n;
    private static int[] parents;
    private static PriorityQueue<int[]> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        graph = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            graph.add(new int[]{a, b, c});
        }

        parents = new int[n + 1];
        for(int i=1 ; i<=n ; i++)
            parents[i] = i;

        bw.write(String.valueOf(MST()));
        bw.close();
        br.close();
    }

    private static int MST(){
        int ret = 0;
        while(!graph.isEmpty()){
            int[] cur = graph.poll();

            int sour = cur[0], des = cur[1], cost = cur[2];

            if(findParent(sour) == findParent(des))
                continue;
                
            ret += cost;
            union(sour, des);
        }

        return ret;
    }

    private static int findParent(int x){
        if(x == parents[x])
            return x;

        return parents[x] = findParent(parents[x]);
    }

    private static void union(int y, int x){
        int py = findParent(y);
        int px = findParent(x);

        if(py == px)
            return;

        parents[py] = px;
    }
}