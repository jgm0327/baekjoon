import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    private static boolean[] visit;
    private static int n, m;
    private static List<Integer>[] list;
    private static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++)list[i] = new ArrayList<>();

        while(m-- > 0){
            String[] values = br.readLine().split(" ");
            int sour = Integer.parseInt(values[0]), des = Integer.parseInt(values[1]);
            list[sour].add(des);
            list[des].add(sour);
        }

        visit = new boolean[n+1];
        dfs(1);
        System.out.println(answer - 1);
        br.close(); 
    }

    private static void dfs(int sour){
        if(visit[sour])return;
        answer++;
        visit[sour] = true;

        for(int des : list[sour]){
            if(!visit[des])dfs(des);
        }
    }
}