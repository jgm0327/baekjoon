import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        long[] greenOnions = new long[s];
        long total = 0;
        for(int i=0 ; i<s ; i++){
            greenOnions[i] = Integer.parseInt(br.readLine());
            total += greenOnions[i];
        }

        long left = 0, right = Integer.MAX_VALUE;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2; // 양파의 최대 길이
            long count = 0;

            for(long greenOnion : greenOnions){
                long divide = greenOnion / mid;

                count += divide;
            }

            if(count >= c){
                left = mid + 1;
                answer =  total - mid * (count - (count - c));
            }else{
                right = mid - 1;
            }
        }

        bw.write(Long.toString(answer));
        bw.close();
    }
}