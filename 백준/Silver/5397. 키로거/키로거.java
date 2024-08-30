import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        while(n-- > 0){
            String input = br.readLine();

            StringBuilder front = new StringBuilder();
            StringBuilder back = new StringBuilder();

            for(int i=0 ; i<input.length() ; i++){
                char ch = input.charAt(i);

                if(ch == '-' && front.length() > 0){
                    front.deleteCharAt(front.length() - 1);
                }
                else if(ch == '>' && back.length() > 0){
                    front.append(back.charAt(back.length() - 1));
                    back.deleteCharAt(back.length() - 1);
                }
                else if(ch == '<' && front.length() > 0){
                    back.append(front.charAt(front.length() - 1));
                    front.deleteCharAt(front.length() - 1);
                }
                else if(('a' <= ch && ch <= 'z') 
                || ('A' <= ch && ch <= 'Z')
                || ('0' <= ch && ch <= '9')){
                    front.append(ch);
                }
            }

            answer.append(front).append(back.reverse()).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}