import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> que = new LinkedList<>();
        StringBuilder answer = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String command = stk.nextToken();
            switch(command){
                case "push":
                int data = Integer.parseInt(stk.nextToken());
                que.add(data);
                break;
                case "front":
                if(que.isEmpty())answer.append("-1\n");
                else answer.append(que.peek()).append("\n");
                break;
                case "back":
                if(que.isEmpty()) answer.append("-1\n");
                else answer.append(que.peekLast()).append("\n");
                break;
                case "size":
                answer.append(que.size()).append("\n");
                break;
                case "empty":
                answer.append(que.isEmpty() ? "1\n" : "0\n");
                break;
                case "pop":
                if(que.isEmpty())answer.append("-1\n");
                else answer.append(que.poll()).append("\n");                break;
            }
        }
        System.out.println(answer);

        br.close();
    }
}