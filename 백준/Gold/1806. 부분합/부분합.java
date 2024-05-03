import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    private static int n, m;
    private static int[] numbers;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        numbers = new int[n];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        System.out.println(solution());
    }

    private static int solution(){
        int ret = Integer.MAX_VALUE;

        int left = 0, right = 0, total = 0;

        while(left <= right && left < n){

            if(right >= n || total >= m){
                if(total >= m)
                    ret = Math.min(ret, (right - left));
                total -= numbers[left++];
            }
            else if(right < n){
                total += numbers[right++];
            }

        }

        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}