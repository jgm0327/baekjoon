import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean isEnd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        isEnd = false;
        dfs(new StringBuilder(), n);
    }

    private static void dfs(StringBuilder path, int end){
        if(path.length() == end){
            System.out.println(path);
            isEnd = true;
            return;
        }

        for(int i=1 ; i<4 ; i++){

            path.append(i);
            if(!continuous(path.toString()))dfs(path, end);
            if(isEnd)return;
            path.deleteCharAt(path.length() - 1);
        }
    }

    private static boolean continuous(String str){
        int len = str.length();
        
        for(int i = 1 ; i <= len / 2 ; i++){
            if(!str.substring(len - i * 2, len - i)
            .equals(str.substring(len - i, len)))
                continue;
                
            return true;
        }

        return false;
    }
}