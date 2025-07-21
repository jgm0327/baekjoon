import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] arr = new int[n];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(tokenizer.nextToken());

        int answer = Integer.MAX_VALUE;
        Queue<Integer> que = new ArrayDeque<>();
        for (int right = 0; right < n; right++) {
            if (arr[right] == 1)
                que.add(right);

            if (que.size() == k) {
                answer = Math.min(answer, right - que.poll() + 1);
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }
}