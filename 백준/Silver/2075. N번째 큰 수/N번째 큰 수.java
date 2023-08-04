import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i=0 ; i<n ; i++){
            String[] values = br.readLine().split(" ");
            for(int j=0 ; j<n ; j++){
                pq.add(Integer.parseInt(values[j]));
            }
        }
        int cnt = 1;
        while(!pq.isEmpty() && cnt < n){
            cnt++;
            pq.poll();
        }
        System.out.println(pq.peek());
        br.close();
    }
}