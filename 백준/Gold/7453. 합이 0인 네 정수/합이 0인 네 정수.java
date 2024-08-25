import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[4][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        long[][] sum = new long[2][n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[0][idx] = arr[0][i] + arr[1][j];
                sum[1][idx++] = arr[2][i] + arr[3][j];
            }
        }

        Arrays.sort(sum[0]);
        Arrays.sort(sum[1]);

        System.out.println(solution(sum));

        br.close();
    }

    private static long solution(final long[][] sum) {
        long ret = 0;
        int n = sum[0].length;
        int left = 0, right = n - 1;

        while (left < n && right >= 0) {
            long total = sum[0][left] + sum[1][right];

            if (total < 0)
                left++;
            else if (total > 0)
                right--;
            else {
                long leftCount = 0, rightCount = 0;
                long tLeft = sum[0][left], tRight = sum[1][right];

                while (left < n && tLeft == sum[0][left]) {
                    leftCount++;
                    left++;
                }

                while (right >= 0 && tRight == sum[1][right]) {
                    rightCount++;
                    right--;
                }

                ret += leftCount * rightCount;
            }
        }

        return ret;
    }
}