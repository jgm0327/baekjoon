import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long target = Long.parseLong(br.readLine());
        long sum = 0, num = 0;
        while(sum < target){
            sum += num;
            if(sum >= target)break;
            num++;
        }
        System.out.println(sum > target ? num - 1 : num);
        br.close();
    }
}