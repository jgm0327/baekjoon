import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        int start = 0, end = n - 1, answer = 0;
        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == m)answer++;
            if(sum >= m) end--;
            else start++;
        }
        System.out.println(answer);
        br.close();
    }
}