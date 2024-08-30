import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int[] liquids = new int[n];
        for(int i=0 ; i<n ; i++){
            liquids[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(liquids);

        int left = 0, right = n - 1, answer = Integer.MAX_VALUE;

        while(left < right){
            int total = liquids[left] + liquids[right];
            
            if(Math.abs(answer) > Math.abs(total)){
                answer = total;
            }
            if(total > 0){
                right--;
            }
            else{
                left++;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}