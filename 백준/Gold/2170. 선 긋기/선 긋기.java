import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i=0 ; i<n ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        int start = arr[0][0], end = arr[0][1];
        int answer = 0;

        for(int i=1 ; i<n ; i++){
            if(end < arr[i][0]){
                answer += (end - start);
                start = arr[i][0];
                end = arr[i][1];
            }
            else{
                end = Math.max(end, arr[i][1]);
                start = Math.min(start, arr[i][0]);
            }
        }
        answer += (end - start);

        System.out.println(answer);

    }
}