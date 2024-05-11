import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    private static int cnt = -1, n;
    private static long answer = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int digit = 1;

        while(cnt != n && digit <= 10){
            dfs(0, digit++, new StringBuilder());
        }

        System.out.println(answer);
    }

    private static void dfs(int depth, int limit, StringBuilder number){
        if(depth == limit){
            cnt++;
            if(cnt == n)
                answer = Long.parseLong(number.toString());
            return;
        }

        for(int i=0 ; i<10 ; i++){
            if(number.length() > 0 && (number.charAt(number.length() - 1) - '0') <= i)
                continue;

            number.append(i);
            dfs(depth + 1, limit, number);
            if(answer != -1)return;
            number.deleteCharAt(number.length() - 1);
        }
    }
}