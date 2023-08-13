import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String... args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken()), m = Integer.parseInt(stk.nextToken());
        int[][] arr = new int[m][2];

        for(int i=0 ; i<m ; i++){
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);

        int answer = arr[0][1] * n;
        for(int i=0 ; i<m ; i++){
            int pack = arr[i][0], withPack = n / 6;
            int min = Math.min(withPack * pack + (n - withPack * 6) * arr[0][1],
            (withPack + 1) * pack);
            answer = Math.min(min, answer);
        }

        System.out.println(answer);
        br.close();
    }
}