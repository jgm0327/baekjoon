import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    private static int n;
    private static char[] inequalitySigns;
    private static boolean[] visit;
    private static List<String> answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        inequalitySigns = new char[n];
        for(int i=0 ; i<n ; i++){
            inequalitySigns[i] = tokenizer.nextToken().charAt(0);
        }

        visit = new boolean[10];
        answer = new ArrayList<>();

        dfs(-1, new StringBuilder());

        System.out.println(answer.get(answer.size() - 1) + "\n" + answer.get(0));
    }

    private static void dfs(int depth, StringBuilder path){
        if(depth == n){
            answer.add(path.toString());
            return;
        }

        for(int i=0 ; i<10 ; i++){
            if(visit[i])continue;
            if(depth != -1 && 
            !check(inequalitySigns[depth], i, (int)(path.charAt(path.length() - 1)) - '0'))
                continue;
            
            visit[i] = true;
            path.append(i);
            dfs(depth + 1, path);
            path.deleteCharAt(path.length() - 1);
            visit[i] = false;
        }
    }

    private static boolean check(char inequalitySign, int number, int prev){
        if(inequalitySign == '>'){
            return number < prev;
        }
        
        return number > prev;
    }

}