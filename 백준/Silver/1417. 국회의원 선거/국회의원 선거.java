import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o2-o1);

        int dasom = Integer.parseInt(br.readLine());
        for(int i=2 ; i<=n ; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer= 0 ;
        while(!pq.isEmpty() && dasom <= pq.peek()){
            int cur = pq.poll();
            answer++;
            dasom++;
            pq.add(cur - 1);
        }
        System.out.println(answer);
        br.close();
    }
}