import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n-1], nodes = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n-1 ; i++){
            dist[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            nodes[i] = Integer.parseInt(stk.nextToken());
        }

        long answer = nodes[0] * dist[0], temp = nodes[0];
        for(int i = 1 ; i < n - 1; i++){
            if(temp > nodes[i])temp = nodes[i];
            answer += dist[i] * temp;
        }
        System.out.println(answer);
        br.close();
    }
}