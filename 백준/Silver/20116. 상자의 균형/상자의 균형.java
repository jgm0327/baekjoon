import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());

        int[] centerOfMass = new int[n];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            centerOfMass[i] = Integer.parseInt(tokenizer.nextToken());
        }

        boolean isStable = true;
        double total = 0;

        for(int i=n-1 ; i>0 ; i--){
            total += centerOfMass[i];

            double avg = total / (n - i);
            if(centerOfMass[i - 1] + l <= avg || centerOfMass[i - 1] - l >= avg){
                isStable = false;
                break;
            }
        }

        bw.write(isStable ? "stable" : "unstable");
        
        bw.close();
        br.close();
    }
}