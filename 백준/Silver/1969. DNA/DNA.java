import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        String[] DNA = new String[n];

        for(int i=0 ; i<n ; i++){
            DNA[i] = br.readLine();
        }

        int[][] count = new int[m][26];

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                count[j][DNA[i].charAt(j) - 'A']++;
            }
        }

        char[] alpha = {'A', 'C', 'G', 'T'};

        StringBuilder answerDNA = new StringBuilder();
        int total = 0;
        for(int i=0 ; i<m ; i++){
            int max = 0;
            char ch = 'A';

            for(char al : alpha){
                int idx = al - 'A';

                if(max < count[i][idx]){
                    max = count[i][idx];
                    ch = al;
                }
            }

            total += (n - max);
            answerDNA.append(ch);
        }

        bw.write(answerDNA.append("\n").toString());
        bw.write(String.valueOf(total));
        bw.close();
        br.close();
    }
}