import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int n;
    static String answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        answer = "-1";
        if(n == 0)answer = "0";
        else if(n == 1)answer = "1";

        for(int i=1 ; i<=10 ; i++){
            dfs(new StringBuilder(), i);

            if(n == 0)
                break;
        }

        System.out.println(answer);

        br.close();
    }

    static void dfs(StringBuilder path, int digit){
        if(digit == 0){
            n--;
            if(n == 0)
                answer = path.toString();
            return;
        }

        for(int i=0 ; i<10 ; i++){
            if((path.length() == 0 && i == 0) || (path.length() != 0 && path.charAt(path.length() - 1) - '0' <= i))
                continue;

            path.append(i);
            dfs(path, digit - 1);
            if(n == 0)
                return;
            path.deleteCharAt(path.length() - 1);
        }
    }

}