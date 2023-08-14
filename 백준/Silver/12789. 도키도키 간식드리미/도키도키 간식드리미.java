import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        LinkedList<Integer> stack = new LinkedList<>();
        int number = 1;
        for(int i=0 ; i<n ; i++){
            int cur = Integer.parseInt(stk.nextToken());
            if(cur == number){
                number++;
                continue;
            }
            while(!stack.isEmpty() && number == stack.peekLast()){
                number++;
                stack.pollLast();
            }
            stack.add(cur);
        }

        while(!stack.isEmpty() && number == stack.peekLast()){
                number++;
                stack.pollLast();
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
        br.close();
    }
}