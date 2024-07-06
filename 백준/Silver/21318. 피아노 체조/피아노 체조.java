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

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n + 1];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++){
            scores[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] prefixSum = new int[n + 1];
        int sum = 0;

        for(int i=1 ; i<=n ; i++){
            if(scores[i - 1] > scores[i])
                sum++;

            prefixSum[i] = sum;
        }

        int Q = Integer.parseInt(br.readLine());
        while(Q-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(tokenizer.nextToken());
            int e = Integer.parseInt(tokenizer.nextToken());

            int totalMistakes = prefixSum[e] - prefixSum[s - 1];
            if(prefixSum[s] != prefixSum[s-1])
                totalMistakes--;

            bw.write(totalMistakes + "\n");
        }

        bw.close();
    }
}