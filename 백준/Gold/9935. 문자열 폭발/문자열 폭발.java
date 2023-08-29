import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String bombWord = br.readLine();
        int len = bombWord.length();
        if(str.length() < len){
            System.out.println(str);
            return;
        }
        for(int i=0 ; i<str.length() ; i++){
            sb.append(str.charAt(i));
            int sbLen = sb.length();
            if(sbLen >= len && sb.substring(sbLen - len, sbLen).equals(bombWord)){
                sb.delete(sbLen - len, sbLen);
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
        
        br.close();
    }
}