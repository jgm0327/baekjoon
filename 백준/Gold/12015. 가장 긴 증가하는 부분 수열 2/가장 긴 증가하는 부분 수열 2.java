import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        List<Integer> answer = new ArrayList<>();
        
        for (int i=0 ; i<n ; i++) {
            int number = Integer.parseInt(tokenizer.nextToken());

            if(answer.isEmpty() || answer.get(answer.size() - 1) < number){
                answer.add(number);
                continue;
            }

            int idx = bisectLeft(number, answer);
            answer.set(idx, number);
        }

        System.out.println(answer.size());

        br.close();
    }

    private static int bisectLeft(int target, List<Integer> list) {
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}