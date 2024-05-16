import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        long x = Long.parseLong(split[0]);
        long y = Long.parseLong(split[1]);

        double z = ((y * 100) / x);
        long left = 0, right = Integer.MAX_VALUE;

        long answer = Integer.MAX_VALUE;

        while(left <= right){
            long mid = (left + right) / 2;

            if(z != (((y + mid) * 100) / (x + mid))){
                right = mid - 1;
                answer = Math.min(answer, mid);
            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

}