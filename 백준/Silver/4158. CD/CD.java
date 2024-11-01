import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder answer = new StringBuilder();
        while(true){
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);

            if(n == 0 && m == 0)
                break;

            int[] exist = new int[n];

            for(int i=0 ; i<n ; i++){
                exist[i] = Integer.parseInt(br.readLine());
            }

            int count = 0;
            for(int i=0 ; i<m ; i++){
                if(!binarySearch(Integer.parseInt(br.readLine()), exist))
                    continue;

                count++;
            }

            answer.append(count).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }

    private static boolean binarySearch(int target, int[] exist){
        int left = 0, right = exist.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(exist[mid] == target)
                return true;
            
            if(exist[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}