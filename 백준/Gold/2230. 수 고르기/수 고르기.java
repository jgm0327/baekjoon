import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    private static int n, m;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        
        arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        
        int answer = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++){
            answer = Math.min(answer, findMinDiff(i));
        }
        System.out.println(answer);
        br.close();
    }

    private static int findMinDiff(int idx){
        int start = idx + 1, end = n - 1, ret = Integer.MAX_VALUE;
        while(start <= end){
            int mid = (start + end) / 2;
            int diff = Math.abs(arr[idx] - arr[mid]);

            if(m <= diff){
                ret = Math.min(ret, diff);
                end = mid -1;
            }
            else {
                start = mid + 1;
            }
        }
        return ret;
    }
}