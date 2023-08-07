import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]), money = Integer.parseInt(size[1]);

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
         
        int answer = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(money >= arr[i]){
                int cnt = money / arr[i];
                money -= arr[i] * cnt;
                answer += cnt;
            }
        }

        System.out.println(answer);
        br.close();
    }
}