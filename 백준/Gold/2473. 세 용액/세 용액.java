import java.io.*;
import java.util.*;

class Main {
    static int n;
    static long[] liquid;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        liquid = new long[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Long.parseLong(tokenizer.nextToken());
        }

        Arrays.sort(liquid);
        long minValue = Long.MAX_VALUE;
        long[] answer = new long[3];
        for (int left = 0; left < n - 2; left++) {
            for (int mid = left + 1; mid < n - 1; mid++) {
                long total = liquid[left] + liquid[mid];

                int index = bisectLeft(-total, mid + 1);
                int right = index;

                if (index - 1 > mid && Math.abs(total + liquid[index - 1]) < Math.abs(total + liquid[index]))
                    right = index - 1;
                if (index + 1 < n && Math.abs(total + liquid[index + 1]) < Math.abs(total + liquid[right]))
                    right = index + 1;

                if (minValue > Math.abs(total + liquid[right])) {
                    minValue = Math.abs(total + liquid[right]);
                    answer = new long[] { liquid[left], liquid[mid], liquid[right] };
                }
            }
        }
        for (int i = 0; i < 3; i++)
            System.out.print(answer[i] + " ");

        br.close();
    }

    static int bisectLeft(long target, int left) {
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (liquid[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return Math.min(left, n - 1);
    }
}