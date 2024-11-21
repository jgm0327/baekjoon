import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int[][] classes = new int[n][2];
        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            tokenizer.nextToken();
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            classes[i] = new int[]{start, end};
        }

        Arrays.sort(classes, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] time : classes){
            int s = time[0], e = time[1];

            if(!pq.isEmpty() && pq.peek() <= s){
                pq.poll();
            }

            pq.add(e);
        }
        
        bw.write(String.valueOf(pq.size()));
        bw.close();
        br.close();
    }
}