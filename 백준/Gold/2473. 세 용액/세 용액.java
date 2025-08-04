import java.util.*;
import java.io.*;

class Main {

    static int n;
    static int[] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(tokenizer.nextToken());

        Arrays.sort(arr);

        int[] answer = new int[3];
        long minValue = Long.MAX_VALUE / 10;
        for (int left = 0; left < n - 2; left++) {
            int mid = left + 1, right = n - 1;

            while (mid < right) {
                long total = (long)arr[left] + (long)arr[mid] + (long)arr[right];

                if (Math.abs(total) < minValue) {
                    minValue = Math.abs(total);
                    answer = new int[]{arr[left], arr[mid], arr[right]};
                }

                if(total < 0)
                    mid++;
                else right--;
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
        br.close();
    }
}