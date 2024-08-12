import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        ArrayDeque<int[]> stk = new ArrayDeque<>();
        int[] count = new int[n];
        
        // System.out.println();
        for (int i = 0; i < n; i++) {
            
            // System.out.println(stk.size() + " " + (stk.isEmpty() ? "null" : stk.peekLast()[1]));
            // for(int c : count){
            //     System.out.print(c + " ");
            // }
            // System.out.println();

            while (!stk.isEmpty() && stk.peekLast()[1] <= height[i]) {
                count[stk.peekLast()[0]] += (i - stk.pollLast()[0] - 1);
            }

            stk.add(new int[] { i, height[i] });
        }

        while (!stk.isEmpty()) {
            count[stk.peekLast()[0]] += (n - 1 - stk.pollLast()[0]);
        }

        long answer = 0;
        for (int c : count) {
            // System.out.print(c + " ");
            answer += c;
        }
        // System.out.println();

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

        br.close();
    }
}