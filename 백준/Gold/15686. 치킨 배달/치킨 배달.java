import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] board;
    static List<int[]> houses;
    static List<int[]> chickenHouses;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        board = new int[n][n];
        houses = new ArrayList<>();
        chickenHouses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (board[i][j] == 1)
                    houses.add(new int[] { i, j });
                else if (board[i][j] == 2)
                    chickenHouses.add(new int[] { i, j });
            }
        }

        System.out.println(dfs(0, m, new ArrayDeque<>(), 0));

        br.close();
    }

    static int calculateDistances(ArrayDeque<int[]> que) {
        int ret = 0;
        for (int[] house : houses) {
            int minValue = Integer.MAX_VALUE;
            for (int[] chickenHouse : que) {
                minValue = Math.min(minValue,
                        Math.abs(house[0] - chickenHouse[0]) + Math.abs(house[1] - chickenHouse[1]));
            }
            ret += minValue;
        }

        return ret;
    }

    static int dfs(int start, int m, ArrayDeque<int[]> que, int visit) {
        if (m == 0)
            return calculateDistances(que);

        int ret = Integer.MAX_VALUE;
        for (int i = start; i < chickenHouses.size(); i++) {
            if ((visit & (1 << i)) != 0)
                continue;

            que.add(chickenHouses.get(i));
            ret = Math.min(dfs(i + 1, m - 1, que, visit | (1 << i)), ret);
            que.pollLast();
        }

        return ret;
    }
}