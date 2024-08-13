import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(stk.nextToken());

            int[] height = new int[20];

            for(int i=0 ; i<20 ; i++)height[i] = Integer.parseInt(stk.nextToken());

            int count = 0;

            for(int i=0 ; i<20 ; i++){
                for(int j=i+1 ; j<20 ; j++){
                    if(height[i] <= height[j])continue;

                    int temp = height[i];
                    height[i] = height[j];
                    height[j] = temp;
                    count++;
                }
            }
            answer.append(t).append(" ").append(count).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();

        br.close();
    }
}