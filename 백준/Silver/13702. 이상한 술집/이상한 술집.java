import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[] alcohol = new int[n];

        for(int i=0 ; i<n ; i++){
            alcohol[i] = Integer.parseInt(br.readLine());
        }

        long left = 0, right = Integer.MAX_VALUE;

        while(left <= right){
            long mid = (left + right) / 2;

            int total = 0;
            for(int i=0 ; i<n ; i++){
                total += (alcohol[i] / mid);
            }

            if(total >= m){
                left = mid + 1;
            }

            else right = mid - 1;
        }

        System.out.println(right);

    }

}