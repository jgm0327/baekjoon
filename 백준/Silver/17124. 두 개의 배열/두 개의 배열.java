import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main{

    private static int n, m;
    private static int[] a, b;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());

            a = new int[n];
            b = new int[m];

            stk = new StringTokenizer(br.readLine());
            for(int i=0 ; i<n ;i++){
                a[i] = Integer.parseInt(stk.nextToken());
            }

            stk = new StringTokenizer(br.readLine());
            for(int i=0 ; i<m ; i++){
                b[i] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(b);

            long answer = 0;

            for(int i=0 ; i<n ; i++){
                int binary = Arrays.binarySearch(b, a[i]);

                if(binary >= 0){
                    answer += b[binary];
                }else if(binary == -1){
                    answer += b[0];
                }else if(Math.abs(binary) - 1 == m){
                    answer += b[m - 1];
                }else{
                    int v1 = b[Math.abs(binary) - 2], v2 = b[Math.abs(binary) - 1];
                    
                    answer += (Math.abs(v1 - a[i]) <= Math.abs(v2 - a[i]) ? v1 : v2);
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}