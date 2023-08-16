import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            StringBuilder answer = new StringBuilder();

            for(int i=0 ; i<str.length() ;i++){
                char ch = str.charAt(i);
                if(ch == ' '){
                    answer.append(sb.reverse().toString()).append(" ");
                    sb = new StringBuilder();
                }
                else
                    sb.append(ch);

            }
            System.out.println(answer.append(sb.reverse().toString()));
        }
        br.close();
    }
}