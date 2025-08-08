import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        list = new ArrayList[n];
        for (int i = 0; i < n; i++)
            list[i] = new ArrayList<>();

        while (m-- > 0) {
            tokenizer = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());

            list[sour].add(des);
            list[des].add(sour);
        }

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (dfs(i, 1, new boolean[n])) {
                flag = true;
                break;
            }
        }

        System.out.println(flag ? 1 : 0);

        br.close();
    }

    static boolean dfs(int sour, int depth, boolean[] visit) {
        if (depth == 5) {
            return true;
        }

        visit[sour] = true;
        for (int des : list[sour]) {
            if (visit[des])
                continue;

            visit[des] = true;
            if (dfs(des, depth + 1, visit))
                return true;
            visit[des] = false;
        }
        visit[sour] = false;

        return false;
    }
}