import java.io.*;
import java.util.*;;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int left = 0, right = 0;
        int[] money = new int[n];        

        for(int i=0 ; i<n ; i++){
            money[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, money[i]);
            right += money[i];
        }

        while(left <= right){
            int k = (left + right) / 2;

            int cur = k, cnt = 1;
            for(int i=0 ; i<n ; i++){
                
                cur -= money[i];

                if(cur < 0){
                    cur = k - money[i];
                    cnt++;
                }
            }

            if(cnt <= m){
                right = k - 1;
            }
            else
                left = k + 1;
        }

        bw.write(String.valueOf(left));
        bw.close();
        br.close();
    }
}