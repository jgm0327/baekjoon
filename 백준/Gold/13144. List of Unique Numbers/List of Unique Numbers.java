import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            numbers[i] = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, Boolean> exist = new HashMap<>();

        int left = 0, right = 0;
        long answer = 0;

        while (right < n) {
            if (!exist.containsKey(numbers[right])) {
                exist.put(numbers[right], true);
                answer++;
                right++;
            }

            else {
                while(exist.containsKey(numbers[right])) {
                    answer += (right - left - 1);
                    exist.remove(numbers[left]);
                    left++;
                }
            }
        }

        // 1 2 2 2 1
        // 1 2, 2 1

        long range = right - left - 1;
        answer += ((range + 1) * range) / 2;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

        br.close();
    }
}