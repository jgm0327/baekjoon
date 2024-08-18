import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] scores = new int[n];
        tokenizer = new StringTokenizer(br.readLine());

        for(int i=0 ; i<n ; i++){
            scores[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int left = 0, right = 1000_000_000;

        while(left <= right){
            int mid = (left + right) / 2;

            int count = 0, totalScore = 0;
            for(int score : scores){
                totalScore += score;

                if(totalScore >= mid){
                    count++;
                    totalScore = 0;
                }
            }

            if(count >= k){
                left = mid + 1;
                
            }else{
                right = mid - 1;
            }
        }

        bw.write(String.valueOf(right));

        bw.flush();
        bw.close();
        br.close();
    }
}