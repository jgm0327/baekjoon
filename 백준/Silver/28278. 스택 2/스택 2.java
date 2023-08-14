import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> stack = new LinkedList<>();

        StringBuilder answer = new StringBuilder();
        while(n-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int opt = Integer.parseInt(stk.nextToken());
            switch(opt){
                case 1:
                    int data = Integer.parseInt(stk.nextToken());
                    stack.add(data);
                    break;
                case 2:
                    if(stack.isEmpty())
                        answer.append("-1\n");
                    else 
                        answer.append(stack.pollLast()).append("\n");
                    break;
                case 3:
                    answer.append(stack.size()).append("\n");
                    break;
                case 4:
                    if(stack.isEmpty())
                        answer.append("1\n");
                    else
                        answer.append("0\n");
                    break;
                case 5:
                    if(stack.isEmpty())
                        answer.append("-1\n");
                    else 
                        answer.append(stack.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(answer);

        br.close();
    }
}