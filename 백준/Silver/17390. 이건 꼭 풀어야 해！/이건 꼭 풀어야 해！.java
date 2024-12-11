import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int q = Integer.parseInt(tokenizer.nextToken());

        int[] prefix = new int[n + 1];
        int[] arr = new int[n];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);
        for(int i=0 ; i<n ; i++){
            prefix[i + 1] = prefix[i] + arr[i];
        }

        StringBuilder answer = new StringBuilder();
        while(q-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());

            answer.append(prefix[r] - prefix[l - 1]).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}