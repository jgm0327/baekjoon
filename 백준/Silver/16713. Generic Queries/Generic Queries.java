import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] numbers = new int[n + 1];
        int[] prefix = new int[n + 1];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++){
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
            prefix[i] = prefix[i - 1] ^ numbers[i];
        }
        
        int answer = 0;
        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(tokenizer.nextToken());
            int e = Integer.parseInt(tokenizer.nextToken());

            answer ^= (prefix[e] ^ prefix[s - 1]);
        }
        System.out.println(answer);
    }
}