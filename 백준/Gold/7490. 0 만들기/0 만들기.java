import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int n;
    static int[] sign = { 1, -1 };
    static char[] operation = { '+', '-' };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            dfs(2, new StringBuilder("1"), 0, 0, new StringBuilder("1"), answer, false);

            answer.append("\n");
        }

        System.out.print(answer);

        br.close();
    }

    static void dfs(int depth, StringBuilder number, int signIdx, int total, StringBuilder path, StringBuilder answer, boolean flag) {
        if (depth == n + 1) {
            total += Integer.parseInt(number.toString()) * sign[signIdx];
            if(total == 0 && flag) {
                answer.append(path).append("\n");
            }
            return;
        }

        // 공백
        number.append(depth);
        path.append(" ").append(depth);
        dfs(depth + 1, number, signIdx, total, path, answer, flag);
        path.delete(path.length() - 2, path.length());
        number.deleteCharAt(number.length() - 1);

        // +, -
        for (int i = 0; i < 2; i++) {
            path.append(operation[i]).append(depth);

            dfs(depth + 1, new StringBuilder(String.valueOf(depth)), i, total + Integer.parseInt(number.toString()) * sign[signIdx], path, answer, true);

            path.delete(path.length() - 2, path.length());
        }
    }
}
