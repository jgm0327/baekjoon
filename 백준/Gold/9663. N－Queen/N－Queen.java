import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(dfs(n, 0, new int[n], 0));
        br.close();
    }

    static int dfs(int n, int y, int[] visit, int visitX) {
        if (y == n)
            return 1;

        int ret = 0;
        for (int x = 0; x < n; x++) {
            int curBit = (1 << x);

            if (!check(y, x, visit) || (visitX & curBit) != 0)
                continue;

            visit[y] = visit[y] | curBit;
            ret += dfs(n, y + 1, visit, visitX | curBit);
            visit[y] = visit[y] & (~curBit);
        }

        return ret;
    }

    static boolean check(int y, int x, int[] visit) {
        for (int i = 1; i < visit.length; i++) {
            int ny = y - i;
            int leftX = x - i;
            int rightX = x + i;

            if (ny < 0 || (leftX < 0 && rightX >= visit.length))
                return true;

            if ((visit[ny] & (1 << leftX)) != 0 || (visit[ny] & (1 << rightX)) != 0)
                return false;
        }

        return true;
    }
}