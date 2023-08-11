import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0 ; i<n ; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(true){
            int num1 = pq.poll();
            if(pq.isEmpty()){
                break;
            }
            int num2 = pq.poll();
            answer += (num1 + num2);
            pq.add(num1 + num2);
        }
        System.out.println(answer);

        br.close();
    }
}