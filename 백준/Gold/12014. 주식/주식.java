import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for(int t=1 ; t<=T ; t++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());

            int[] arr = new int[n];
            tokenizer = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();

            for(int i=0 ; i<n ; i++){
                int number = Integer.parseInt(tokenizer.nextToken());
                if(list.isEmpty() || list.get(list.size() - 1) < number){
                    list.add(number);
                    continue;
                }

                int idx = bisectLeft(number, list);
                list.set(idx, number);
            }

            answer.append("Case #").append(t).append("\n");
            if(list.size() >= k)
                answer.append(1);
            else
                answer.append(0);

            answer.append("\n");
        }

        System.out.print(answer);
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