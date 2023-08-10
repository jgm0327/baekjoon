import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0, n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];

        for(int i=0 ;i<n ; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int cnt = 1;
        for(int i = n - 1 ; i >= 0 ; i--){
            answer = Math.max(ropes[i] * cnt, answer);
            cnt++;
        }
        System.out.println(answer);
        br.close();
    }
}