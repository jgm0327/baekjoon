import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        StringTokenizer tokenizer;
        
        if(n > 0){
            tokenizer = new StringTokenizer(br.readLine());

            for(int i=0 ; i<n ; i++){
                broken[Integer.parseInt(tokenizer.nextToken())] = true;
            }
        }

        int answer = Math.abs(target - 100);
        for(int i=0 ; i<=999999 ; i++){
            String number = String.valueOf(i);
            boolean cantPush = false;

            for(int j=0 ; j<number.length() ; j++){
                if(broken[number.charAt(j) - '0']){
                    cantPush = true;
                    break;
                }
            }

            if(!cantPush){
                answer = Math.min(answer, Math.abs(target - i) + number.length());
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}