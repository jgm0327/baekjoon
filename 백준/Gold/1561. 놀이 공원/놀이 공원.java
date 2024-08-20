import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        long[] times = new long[m];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<m ; i++){
            times[i] = Integer.parseInt(tokenizer.nextToken());
        }

        if(n <= m)System.out.println(n);
        else solution(times, n);

        br.close();
    }

    private static void solution(long[] times, long n){
        long left = 0, right = 30 * n;

        while(left <= right){
            long mid = (left + right) / 2;

            long count = countPeople(mid, times);

            if(count >= n){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        long count = countPeople(left - 1, times);

        for(int i=0 ; i<times.length ; i++){
            if(left % times[i] == 0)count++;

            if(count == n){
                System.out.println(i + 1);
                return;
            }
        }

        // System.out.println(left);
        /**
         * 1: 1 2 3 4 5 6 7 8 9 10
         * 2: 1 0 2 0 3 0 4 0 5 0
         * 3: 1 0 0 2 0 0 3 0 0 4
         * 4: 1 0 0 0 2 0 0 0 3 0
         * 5: 1 0 0 0 0 2 0 0 0 0
         */
    }

    private static long countPeople(long t, long[] times){
        long ret = times.length;

        for(long time : times){
            ret += (t / time);
        }

        return ret;
    }
}