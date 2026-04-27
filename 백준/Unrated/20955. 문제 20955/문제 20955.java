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

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parents[i] = i;

        int answer = 0;
        while (m-- > 0) {
            tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            if (findParent(a) == findParent(b))
                answer++;

            union(a, b);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(findParent(i));
        }

        System.out.println(answer + set.size() - 1);

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