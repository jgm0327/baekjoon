import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringBuilder answer = new StringBuilder();
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input.trim());

            StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());

            int[] money = new int[n];
            for (int i = 0; i < n; i++)
                money[i] = Integer.parseInt(tokenizer.nextToken());

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (list.isEmpty() || list.get(list.size() - 1) < money[i]) {
                    list.add(money[i]);
                    continue;
                }

                int idx = bisectLeft(money[i], list);
                list.set(idx, money[i]);            
            }

            answer.append(list.size()).append("\n");
        }

        System.out.println(answer);

        br.close();
    }

    static int bisectLeft(int target, List<Integer> list) {
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target <= list.get(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}