import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int[] prefixEven = new int[n + 1], prefixOdd = new int[n + 1];

        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
            if(i % 2 == 0){
                prefixOdd[i + 1] = prefixOdd[i] + arr[i];
                prefixEven[i + 1] = prefixEven[i];
            }
            else{
                prefixOdd[i + 1] = prefixOdd[i];
                prefixEven[i + 1] = prefixEven[i] + arr[i];
            }
        }

        int answer = 0;
        
        for(int i=1 ; i<=n ; i++){
            if(i % 2 == 0){
                answer = Math.max(answer, prefixOdd[i] + prefixEven[n - 1] - prefixEven[i - 1]);
            }
            else{
                answer = Math.max(answer, prefixOdd[i - 1] + prefixEven[n] - prefixEven[i - 1]);

            }
        }

        bw.write(String.valueOf(answer));


        bw.close();
        br.close();
    }
}