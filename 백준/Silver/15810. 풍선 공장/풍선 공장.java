import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] times = new int[n];
        tokenizer = new StringTokenizer(br.readLine());

        for(int i=0 ; i<n ; i++){
            times[i] = Integer.parseInt(tokenizer.nextToken());
        }

        long left = 1, right = 1000000000000L;

        while(left <= right){
            long mid = (left + right) / 2;

            long total = 0;
            for(int i=0 ; i<n ; i++){
                total += (mid / times[i]);
            }

            if(total >= m){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

}