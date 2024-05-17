import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;

        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
        }

        long left = min, right = Integer.MAX_VALUE, answer = 1;
        while(left <= right){
            long mid = (left + right) / 2;

            long total = 0;
            for(int i=0 ; i<n ; i++){
                if(mid <= arr[i])continue;
                total += (mid - arr[i]);
            }

            if(total > m){
                right = mid - 1;
            }else{
                answer = Math.max(mid, answer);
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

}