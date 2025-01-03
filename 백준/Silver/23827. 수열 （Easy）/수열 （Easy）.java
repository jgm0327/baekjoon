import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        long[] prefix = new long[n + 1];
        long[] arr = new long[n];
        for(int i=1 ; i<=n ; i++){
            arr[i - 1] = Integer.parseInt(tokenizer.nextToken());
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        long answer = 0;
        for(int i=0 ; i<n ; i++){
            answer += ((prefix[n] - prefix[i + 1]) * arr[i]) % 1_000_000_007;
            answer %= 1_000_000_007;
        }
        
        bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}
}