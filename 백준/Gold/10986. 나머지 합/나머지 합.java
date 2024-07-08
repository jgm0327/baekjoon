import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        
        long[] remainder = new long[m];
        long sum = 0;

        for(int i=1 ; i<=n ; i++){
            sum += Integer.parseInt(tokenizer.nextToken());

            int idx = (int)(sum % m);
            remainder[idx]++;
        }

        long answer = remainder[0];
        for(int i=0 ; i<m ; i++){
            answer += (remainder[i] * (remainder[i] - 1)) / 2;
        }
        
        bw.write(answer + "");
        bw.close();
    }
}