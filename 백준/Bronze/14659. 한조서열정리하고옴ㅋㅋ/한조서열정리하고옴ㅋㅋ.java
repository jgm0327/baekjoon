import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            heights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int left = 0, right = 1;
        int answer = 0;

        while(right < n){
            if(heights[left] < heights[right]){
                answer = Math.max(answer, right - left - 1);
                left = right;
            }

            right++;
        }

        answer = Math.max(answer, n - left - 1);

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}