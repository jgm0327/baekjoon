import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int q = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] student = new int[n + 4];
        boolean[] sleep = new boolean[n + 4];

        tokenizer = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            int idx = Integer.parseInt(tokenizer.nextToken());
            sleep[idx] = true;
        }

        Arrays.fill(student, 1);

        tokenizer = new StringTokenizer(br.readLine());
        while (q-- > 0) {
            int number = Integer.parseInt(tokenizer.nextToken());

            if(sleep[number])
                continue;
    
            for(int j=number ; j<n+4 ; j += number){
                if(sleep[j]) continue;
    
                student[j] = 0;
            }
        }

        int total = 0;
        student[2] = 0;
        for(int i=3 ; i<n+4 ; i++){
            if(student[i] == 1)
                total++;
            
            student[i] = total;
        }

        student[2] = 0;
        StringBuilder answer = new StringBuilder();
        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(tokenizer.nextToken());
            int e = Integer.parseInt(tokenizer.nextToken());

            answer.append(student[e] - student[s - 1]).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
    }
}