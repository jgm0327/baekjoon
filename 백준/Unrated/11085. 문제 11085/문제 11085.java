import java.io.*;
import java.util.*;

class Main {
    static int[] parents;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(tokenizer.nextToken());
        int e = Integer.parseInt(tokenizer.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);

        parents = new int[n];
        for(int i=0 ; i<n ; i++)
            parents[i] = i;

        while (m-- > 0) {
            tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int dist = Integer.parseInt(tokenizer.nextToken());

            pq.add(new int[] { a, b, dist });
        }

        int answer = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            union(cur[0], cur[1]);
            answer = cur[2];
            if(findParent(s) == findParent(e))
                break;
        }
        System.out.println(answer);

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

        parents[px] = py;
    }
}