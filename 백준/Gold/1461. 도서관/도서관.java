import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        PriorityQueue<Integer> plus = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minus = new PriorityQueue<>((o1, o2) -> o2 - o1);

        stk = new StringTokenizer(br.readLine());
        
        plus.add(0);
        minus.add(0);
        for(int i=0 ; i<n ; i++){
            int number = Integer.parseInt(stk.nextToken());

            if(number < 0)minus.add(-number);
            else plus.add(number);
        }

        int answer = 0;
        if(minus.peek() > plus.peek()){
            answer = countMinValue(plus, minus, m);
        }else{
            answer = countMinValue(minus, plus, m);
        }

        System.out.println(answer);

    }

    private static int countMinValue(Queue<Integer> que1, Queue<Integer> que2, int m){
        int ret = 0;

        ret += putBookInRightPosition(que1, m);

        if(que2.isEmpty()){
            return ret;
        }
        ret += que2.peek();
        for(int i=0 ; i<m ; i++){
            if(que2.isEmpty())break;
            que2.poll();
        }

        ret += putBookInRightPosition(que2, m);

        return ret;
    }

    private static int putBookInRightPosition(Queue<Integer> que, int m){
        int ret = 0;
        while(!que.isEmpty()){
            ret += que.peek() * 2;

            for(int i=0 ; i<m ; i++){
                if(que.isEmpty())break;
                que.poll();
            }
        }
        return ret;
    }
}