import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for(int i=0 ; i<n ; i++){
                StringTokenizer stk = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(stk.nextToken());
                arr[i][1] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(arr, (o1, o2) -> {
                if(o1[0] != o2[0])return o1[0] - o2[0];
                else return o1[1] - o2[1];
            });

            int temp = arr[0][1], answer = 0;
            for(int i=0 ; i<n; i++){
                if(temp >= arr[i][1]){
                    temp = arr[i][1];
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}