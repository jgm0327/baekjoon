import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        
        while(n-- > 0){
            String str = br.readLine();
            boolean flag = true;
            stack.clear();
            for(int i=0 ; i<str.length() ; i++){
                char ch = str.charAt(i);
                if(ch == '(')
                    stack.add(ch);
                else if(ch == ')'){
                    if(!stack.isEmpty()){
                        stack.poll();
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            answer.append(flag && stack.isEmpty() ? "YES\n" : "NO\n");
        }
        System.out.println(answer);
        br.close();
    }
}