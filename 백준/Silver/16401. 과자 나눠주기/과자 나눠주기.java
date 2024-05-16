import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] snacks = new int[m];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<m ; i++){
            snacks[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int left = 1, right = 1000000000;

        while(left <= right){
            int mid = (left + right) / 2;

            int total = 0;
            for(int i=0 ; i<m ; i++){
                total += (snacks[i] / mid);
            }

            if(total >= n){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

}