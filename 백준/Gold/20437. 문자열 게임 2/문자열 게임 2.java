import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while(T-- > 0){
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if(k == 1){
                answer.append(1).append(" ").append(1).append("\n");
                continue;
            }

            int[] alphabet = new int[26];
            for(int i=0 ; i<str.length() ; i++){
                alphabet[str.charAt(i) - 'a']++;
            }

            answer.append(solution(str, k, alphabet)).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();

        br.close();
    }

    private static String solution(String str, int k, final int[] alphabet){
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;

        for(int i=0 ; i<str.length() ; i++){
            if(alphabet[str.charAt(i) - 'a'] < k)continue;
            
            int count = 1;
            for(int j=i+1 ; j<str.length() ; j++){
                if(str.charAt(i) == str.charAt(j))count++;

                if(count == k){
                    minValue = Math.min(minValue, j - i + 1);
                    maxValue = Math.max(maxValue, j - i + 1);
                    break;
                }
            }
        }

        if(minValue == Integer.MAX_VALUE){
            return String.valueOf(-1);
        }

        return new StringBuilder().append(minValue).append(" ")
            .append(maxValue).toString();
    }
}