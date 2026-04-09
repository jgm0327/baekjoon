import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] pre, last;
    static boolean[][] order;
    static List<Integer>[] graph;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++)
                graph[i] = new ArrayList<>();

            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            last = new int[n + 1];
            for (int i = 1; i <= n; i++)
                last[i] = Integer.parseInt(tokenizer.nextToken());

            pre = new int[n + 1];
            int[] prefix = new int[n + 1];
            order = new boolean[n + 1][n + 1];
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    pre[last[j]]++;
                    prefix[last[j]]++;
                    graph[last[i]].add(last[j]);
                    order[last[i]][last[j]] = true;
                }
            }

            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                tokenizer = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());

                if (order[a][b]) {
                    pre[a]++;
                    pre[b]--;
                    order[a][b] = false;
                    order[b][a] = true;
                    graph[b].add(a);
                } else {
                    pre[a]--;
                    pre[b]++;
                    order[a][b] = true;
                    order[b][a] = false;
                    graph[a].add(b);
                }
            }

            ArrayDeque<Integer> que = new ArrayDeque<>();
            boolean[] visit = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (pre[i] != 0)
                    continue;

                visit[i] = true;
                que.add(i);
            }

            ArrayList<Integer> list = new ArrayList<>();
            if (!topology(que, list, visit)) {
                answer.append("IMPOSSIBLE\n");
                continue;
            }

            for (int num : list) {
                answer.append(num).append(' ');
            }
            answer.append('\n');
        }
        System.out.print(answer);

        br.close();
    }

    static boolean topology(Queue<Integer> que, ArrayList<Integer> list, boolean[] visit) {
        while (!que.isEmpty()) {
            int num = que.poll();

            list.add(num);
            for (int next : graph[num]) {
                if(!order[num][next])
                    continue;

                pre[next]--;
                if (pre[next] > 0 || visit[next])
                    continue;

                visit[next] = true;
                que.add(next);
            }
        }

        return list.size() == n;
    }
}