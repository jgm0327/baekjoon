import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

class Main{
    private static int n, k;
    private static Queue<Integer> que;

    public static void main(String[] args) throws IOException{
        input();
        solution();
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        k = Integer.parseInt(size[1]);

        que = new LinkedList<>();
        for(int i=1 ; i<=n ; i++){
            que.add(i);
        }
        br.close();
    }

    private static void solution() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");

        while(!que.isEmpty()){
            for(int i=1 ; i<k ; i++){
                int num = que.poll();
                que.add(num);
            }
            bw.write(String.valueOf(que.poll()));
            if(que.size() >= 1)bw.write(", ");
        }

        bw.write(">");
        bw.flush();
        bw.close();
    }
}