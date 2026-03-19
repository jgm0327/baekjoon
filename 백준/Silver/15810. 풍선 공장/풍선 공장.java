import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        int[] ballons = new int[n];
        for (int i = 0; i < n; i++)
            ballons[i] = Integer.parseInt(tokenizer.nextToken());

        long left = 0, right = 1_000_000_000_000L;
        while (left <= right) {
            long mid = (left + right) / 2;

            long total = 0;
            for (int i = 0; i < n; i++) {
                total += mid / ballons[i];
            }

            if (total >= m)
                right = mid - 1;
            else
                left = mid + 1;
        }

        System.out.println(left);

        br.close();
    }
}