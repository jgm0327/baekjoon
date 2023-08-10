import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            A[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            B[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for(int i=0 ; i<n ; i++){
            answer += A[i] * B[n - i - 1];
        }
        System.out.println(answer);
        br.close();
    }
}