import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long left = 1, right = k;
        
        while(left < right){
            long mid = (left + right) / 2;

            long count = 0;
            for(int i=1 ; i<=n ; i++){
                count += Math.min(mid / i, n);
            }

            if(count >= k){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(right);
         

        br.close();
    }
}