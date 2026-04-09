import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!dfs(i, i, new boolean[n + 1]))
                continue;

            list.add(i);
        }

        StringBuilder answer = new StringBuilder();
        answer.append(list.size()).append("\n");
        for (int num : list)
            answer.append(num).append('\n');
        System.out.print(answer);

        br.close();
    }

    static boolean dfs(int sour, int start, boolean[] visit) {
        if (visit[sour]) {
            if (sour == start)
                return true;
            return false;
        }
        visit[sour] = true;

        if (dfs(arr[sour], start, visit))
            return true;

        return false;
    }
}