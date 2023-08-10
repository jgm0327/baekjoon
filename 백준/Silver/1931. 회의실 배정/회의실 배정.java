import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] rooms = new int[n][2];
        for(int i=0 ; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(stk.nextToken());
            rooms[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(rooms, (o1, o2) -> {
            if(o1[1] != o2[1])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int end = 0, answer = 0;
        for(int i=0 ; i<n ; i++){
            if(end <= rooms[i][0]){
                answer++;
                end = rooms[i][1];
            }
        }
        System.out.println(answer);
        br.close();
    }
}