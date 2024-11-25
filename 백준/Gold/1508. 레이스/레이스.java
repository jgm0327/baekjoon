import java.io.*;
import java.util.*;

class Main {
    // 반례 참고
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] points = new int[k];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<k ; i++){
            points[i] = Integer.parseInt(tokenizer.nextToken());
        }

        String answer = "";

        int left = 0, right = n;
        while(left <= right){
            int mid = (left + right) / 2;

            int total = 1, prev = points[0], cnt = 1;
            long temp = 1;
            for(int i=1 ; i<k ; i++){
                int c = 0;
                if(mid < points[i] - prev){
                    total++;
                    prev = points[i];
                    cnt++;
                    
                    if(cnt <= m)
                        c = 1;
                }

                temp = ((temp << 1) | c);
            }

            if(total >= m){
                left = mid + 1;
                answer = Long.toBinaryString(temp);
            }
            else
                right = mid - 1;
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}