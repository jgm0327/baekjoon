import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        for(int i=0 ; i<n ; i++){
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int answer = 1;

        for(int i=0 ; i<n ; i++){

            for(int j=i+1 ; j<n ; j++){
                if(numbers[i] < numbers[j])
                    dp[j] = Math.max(dp[j], dp[i] + 1);

                answer = Math.max(dp[j], answer);
            }
        }

        System.out.println(answer);

        br.close();
    }
}