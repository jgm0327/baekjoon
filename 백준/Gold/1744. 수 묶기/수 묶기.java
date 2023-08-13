import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main{
    public static void main(String... args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        for(int i=0 ; i<n ; i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= 0)negative.add(num);
            else positive.add(num);
        }

        int answer = 0;
        while(!positive.isEmpty()){
            int num1 = positive.poll();
            if(positive.isEmpty()){
                answer += num1;
                break;
            }
            int num2 = positive.poll();
            if(num1 == 1 || num2 == 1)answer += (num1 + num2);
            else answer += (num1 * num2);
        }

        while(!negative.isEmpty()){
            int num1 = negative.poll();
            if(negative.isEmpty()){
                answer += num1;
                break;
            }
            int num2 = negative.poll();
            answer += (num1 * num2);
        }


        System.out.println(answer);
        br.close();
    }
}