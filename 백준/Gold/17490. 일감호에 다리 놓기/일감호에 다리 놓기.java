import java.io.*;
import java.util.*;

class Main {
    static int[] s, parents;
    static Map<Integer, Boolean>[] blocked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        long k = Long.parseLong(tokenizer.nextToken());

        s = new int[n + 1];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(tokenizer.nextToken());
        }

        blocked = new HashMap[n + 1];
        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            blocked[i] = new HashMap<>();
            parents[i] = i;
        }

        while (m-- > 0) {
            tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            blocked[a].put(b, true);
            blocked[b].put(a, true);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int next = i + 1;
            if (next > n)
                next = 1;

            if (blocked[i].containsKey(next))
                continue;

            union(i, next);
            cnt++;
        }

        if(cnt >= n - 1){
            System.out.println("YES");
            return;
        }
            

        long[] minValue = new long[n + 1];
        Arrays.fill(minValue, Long.MAX_VALUE);

        for(int i=1 ; i<=n ; i++){
            int pi = findParent(i);
            minValue[pi] = Math.min(minValue[pi], s[i - 1]);
        }

        String answer = "YES";

        long total = 0;
        for(int i=1 ; i<=n ; i++){
            if(minValue[i] == Long.MAX_VALUE)
                continue;

            total = total + (long)minValue[i];

            if(total > k)
                break;
        }

        if(total > k)
            answer = "NO";

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