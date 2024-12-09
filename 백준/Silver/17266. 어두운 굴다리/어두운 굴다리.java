import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] lights = new int[m];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<m ; i++){
            lights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int left = 0, right = n;
        while(left <= right){
            int mid = (left + right) / 2;

            int start = lights[0] - mid, end = lights[0] + mid;
            for(int i=1 ; i<m ; i++){
                if(end < lights[i] - mid){
                    break;
                }

                end = lights[i] + mid;
            }

            if(start <= 0 && end >= n){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(left));
        bw.close();
        br.close();
    }
}