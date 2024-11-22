import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] coupons = new int[n][2];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        for(int i=0 ; i<n ; i++){
            coupons[i][0] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(br.readLine());

        for(int i=0 ; i<n ; i++){
            coupons[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(coupons, (o1, o2) -> {
            if(o1[1] != o2[1])
                return o1[1] - o2[1];

            return o1[0] - o2[0];
        });

        long answer = 0, prev = coupons[0][1], maxValue = 0, cnt = 0;
        for(int i=0 ; i<n ; i++){
            int[] coupon = coupons[i];

            if(prev > coupon[0]){
                prev = Math.max(prev, coupon[1]);

                cnt = (int)Math.ceil((double)(prev - coupon[0]) / 30);
                answer += cnt;
                coupon[0] += cnt * 30;
            }
            
            maxValue = Math.max(maxValue, coupon[0]);

            if(i < n - 1 && coupons[i + 1][1] != coupons[i][1])
                prev = maxValue;
        }
        

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}