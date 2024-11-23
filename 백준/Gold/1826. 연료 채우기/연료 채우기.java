import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer tokenizer;
        PriorityQueue<int[]> gasStations = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            gasStations.add(new int[]{a, b});
        }

        tokenizer = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(tokenizer.nextToken());
        int p = Integer.parseInt(tokenizer.nextToken());

        bw.write(String.valueOf(solution(gasStations, l, p)));
        bw.close();
        br.close();
    }

    private static int solution(PriorityQueue<int[]> gasStations, int l, int p){
        PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
        while(p < l){
            while(!gasStations.isEmpty() && gasStations.peek()[0] <= p){
                fuels.add(gasStations.poll()[1]);
            }

            if(fuels.isEmpty())
                return -1;

            p += fuels.poll();
            cnt++;
        }

        return cnt;
    }
}