import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    private static int n;
    private static int[] liquids;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        liquids = new int[n];
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            liquids[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(liquids);
        long min = Long.MAX_VALUE;
        int[] answer = new int[3];
        for(int i=0 ; i<n ; i++){
            int start = i + 1, end = n - 1;
            while(start < end){
                long data = (long)liquids[i] + (long)liquids[start] + (long)liquids[end];
                if(min > Math.abs(data)){
                    min = Math.abs(data);
                    answer = new int[]{liquids[i], liquids[start], liquids[end]};
                }
                if(data < 0)start++;
                else end--;
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
        br.close();
    }
}