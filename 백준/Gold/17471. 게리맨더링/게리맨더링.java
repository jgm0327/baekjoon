import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    private static int n, answer;
    private static boolean[] v;
    private static int[] population;
    private static List<Integer>[] graph;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(tokenizer.nextToken());
        }

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(tokenizer.nextToken());

            while (m-- > 0) {
                graph[i].add(Integer.parseInt(tokenizer.nextToken()));
            }
        }

        answer = Integer.MAX_VALUE;

        v = new boolean[n + 1];
        dfs(1, 0, new boolean[n + 1]);
        if (answer == Integer.MAX_VALUE)
            answer = -1;

        System.out.println(answer);

        br.close();
    }

    private static void dfs(int start, int depth, boolean[] visit) {
        if (0 < depth && depth < n) {
            Arrays.fill(v, false);
            int cnt = 0, A = 0, B = 0;

            for (int i = 1; i <= n; i++) {
                if (v[i])
                    continue;

                if (visit[i])
                    A = bfs(i, visit, v, visit[i]);
                else
                    B = bfs(i, visit, v, visit[i]);

                cnt++;

                if (cnt > 2)
                    break;
            }

            if (cnt == 2) {
                answer = Math.min(answer, Math.abs(A - B));
            }
        }

        for (int i = start; i <= n; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            dfs(i + 1, depth + 1, visit);
            visit[i] = false;
        }
    }

    private static int bfs(int start, boolean[] A, boolean[] v, boolean cur) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);

        int ret = 0;
        boolean[] visit = new boolean[n + 1];
        visit[start] = true;

        while (!que.isEmpty()) {
            int sour = que.poll();

            v[sour] = true;
            ret += population[sour];
            for (int des : graph[sour]) {
                if (visit[des] || A[des] != cur)
                    continue;

                visit[des] = true;
                que.add(des);
            }
        }

        return ret;
    }
}