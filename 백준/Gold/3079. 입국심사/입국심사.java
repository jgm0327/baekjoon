import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[] gate = new int[n];
        for(int i=0 ; i<n ; i++){
            gate[i] = Integer.parseInt(br.readLine());
        }

        long left = 0, right = (long)1e18;

        long answer = right;
        while(left <= right){
            long mid = (left + right) / 2;

            long count = 0;
            for(int i=0 ; i<n ; i++){
                if(count + (mid / gate[i]) < 0)break;
                count += (mid /gate[i]);
            }

            if(count >= m){
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
            else{
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}