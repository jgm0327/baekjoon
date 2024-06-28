import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    private static String data1, data2, concat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder answer = new StringBuilder();
        for(int t=1 ; t<=T ; t++){
            
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            
            data1 = tokenizer.nextToken();
            data2 = tokenizer.nextToken();
            concat = tokenizer.nextToken();
            

            answer.append("Data set ").append(t)
            .append(bfs() ? ": yes\n" : ": no\n");
        }

        System.out.print(answer);
    }

    private static boolean bfs(){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0,0,0});
        int len1 = data1.length(), len2 = data2.length();

        boolean[][] visit = new boolean[len1 + 1][len2 + 1];
        visit[0][0] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int idx1 = cur[0], idx2 = cur[1], idx3 = cur[2];

            if(cur[2] == concat.length())
                return true;

            if(idx1 < len1 && concat.charAt(idx3) == data1.charAt(idx1) && !visit[idx1 + 1][idx2]){
                que.add(new int[]{idx1 + 1, idx2, idx3 + 1});
                visit[idx1 + 1][idx2] = true;
            }
            if(idx2 < len2 && concat.charAt(idx3) == data2.charAt(idx2) && !visit[idx1][idx2 + 1]){
                que.add(new int[]{idx1, idx2 + 1, idx3 + 1});
                visit[idx1][idx2 + 1] = true;
            }
        }

        return false;
    }
}