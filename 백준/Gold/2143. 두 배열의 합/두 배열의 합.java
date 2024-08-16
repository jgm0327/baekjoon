import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] prefix1 = new int[n + 1];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        Map<Integer, Integer> sum1 = new HashMap<>();
        for(int i=1 ; i<=n ; i++){
            prefix1[i] = prefix1[i - 1] + Integer.parseInt(tokenizer.nextToken());
        }

        for(int i=1 ; i<=n ; i++){
            for(int j=0 ; j<i ; j++){
                int diff = prefix1[i] - prefix1[j];
                sum1.put(diff, sum1.getOrDefault(diff, 0) + 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] prefix2 = new int[m + 1];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=m ; i++){
            prefix2[i] = prefix2[i - 1] + Integer.parseInt(tokenizer.nextToken());
        }

        long answer = 0;
        for(int i=1 ; i<=m ; i++){
            for(int j=0 ; j<i ; j++){
                int diff = prefix2[i] - prefix2[j];
                if(!sum1.containsKey(T - diff))continue;

                answer += sum1.get(T-diff);
            }
        }

        System.out.println(answer);

        br.close();
    }

}