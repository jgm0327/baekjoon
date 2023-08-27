import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken()), m = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int start = 0, end = 0, answer = 0, total = 0;

        while(true){
            if(total >= m)total -= arr[start++];
            else if(end == n)break;
            else total += arr[end++];
            if(total == m)answer++;
        }
        System.out.println(answer);
        br.close();
    }
}