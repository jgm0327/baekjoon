import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int s = Integer.parseInt(tokenizer.nextToken());

        int[] prefix = new int[n + 1];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            prefix[i+ 1] = prefix[i] + Integer.parseInt(tokenizer.nextToken());
        }

        int left = 0, right = 1, answer = Integer.MAX_VALUE;
        while(left <= right && right <= n){
            if(s > prefix[right] - prefix[left]){
                right++;

            }
            else{
                answer = Math.min(answer, right - left);
                left++;
            }
        }
        
        if(answer == Integer.MAX_VALUE)answer=0;
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
