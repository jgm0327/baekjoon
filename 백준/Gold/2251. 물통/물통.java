import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Main{
    private static int A, B, C;
    private static boolean[][][] visit;
    private static HashSet<Integer> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] values = br.readLine().split(" ");
        A = Integer.parseInt(values[0]);
        B = Integer.parseInt(values[1]);
        C = Integer.parseInt(values[2]);
        visit = new boolean[A + 1][B + 1][C + 1];
        set = new HashSet<>();

        dfs(0, 0, C);

        PriorityQueue<Integer> pq = new PriorityQueue<>(set);
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int a, int b, int c){
        if(a < 0 || a > A || b < 0 || b > B || c < 0 || c > C || visit[a][b][c])return;

        if(a == 0)
            set.add(c);
        visit[a][b][c] = true;
        if(c != 0){
            int ta = c <= A - a ? c : A - a,
            tb = c <= B - b ? c : B - b;
            dfs(a + ta, b, c - ta);
            dfs(a, b + tb, c - tb);
        }
        if(b != 0){
            int ta = b <= A - a ? b : A - a,
            tc = b <= C - c ? b : C - c;
            dfs(a + ta, b - ta, c);
            dfs(a, b - tc, c + tc);
        }
        if(a != 0){
            int tc = a <= C - c ? a : C - c,
            tb = a <= B - b ? a : B - b;
            dfs(a - tb, b + tb, c);
            dfs(a - tc, b, c + tc);
        }
    }
}