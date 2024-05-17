import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long left = 1, right = 1000000000, answer = 1;
        while(left <= right){
            long mid = (left + right) / 2;

            
            long total = 0, remain = 0;
            boolean flag = false;

            for(int i=n - 1 ; i>=0 ; i--){
                long amount = (arr[i] / mid);

                if(flag){
                    remain += arr[i];
                    continue;
                }

                if(total + amount > m){
                    flag = true;
                    remain += (m - total) * mid;
                    total = m;
                    continue;
                }

                total += amount;
                remain += (arr[i] % mid);
            }

            if(total >= m){
                left = mid + 1;
                answer = remain;
            }
            else right = mid - 1;
        }

        System.out.println(answer);

    }

}