import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static class RegisterNumber{
        int value;
        StringBuilder path;

        public RegisterNumber(int value, StringBuilder path){
            this.value = value;
            this.path = path;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while(t-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(stk.nextToken());
            int target = Integer.parseInt(stk.nextToken());
            answer.append(bfs(origin, target)).append("\n");
        }

        System.out.print(answer);
    }

    private static String bfs(int origin, int target){
        Queue<RegisterNumber> que = new LinkedList<>();
        boolean[] visit = new boolean[10000];
        final char[] command = new char[]{'D', 'S', 'L', 'R'};

        que.add(new RegisterNumber(origin, new StringBuilder()));

        while(!que.isEmpty()){
            RegisterNumber cur = que.poll();
            
            int D = (cur.value * 2) % 10000;
            int S = cur.value == 0 ? 9999 : cur.value - 1;

            int L = (cur.value % 1000) * 10 + (cur.value / 1000);
            int R = (cur.value % 10) * 1000 + (cur.value / 10);

            int[] numbers = new int[]{D, S, L, R};

            for(int i=0 ; i<4 ; i++){
                int nextValue = numbers[i];

                if(nextValue == target)
                    return cur.path.append(command[i]).toString();

                if(visit[nextValue])continue;

                visit[nextValue] = true;
                que.add(new RegisterNumber(nextValue, new StringBuilder(cur.path).append(command[i])));
            }
        }

        return "";
    }
}