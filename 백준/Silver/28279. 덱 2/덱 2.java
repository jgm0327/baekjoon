import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        LinkedList<Integer> deque = new LinkedList<>();
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int opt = Integer.parseInt(st.nextToken());
            int data = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
            switch(opt){
                case 1:
                    deque.addFirst(data);
                    break;
                case 2:
                    deque.addLast(data);
                    break;
                case 3:
                    answer.append(deque.isEmpty() ? "-1" : deque.pollFirst()).append("\n");
                    break;
                case 4:
                    answer.append(deque.isEmpty() ? "-1" : deque.pollLast()).append("\n");
                    break;
                case 5:
                    answer.append(deque.size()).append("\n");
                    break;
                case 6:
                    answer.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case 7:
                    answer.append(deque.isEmpty() ? "-1" : deque.peekFirst()).append("\n");
                    break;
                case 8:
                    answer.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(answer);
        br.close();
    }
}