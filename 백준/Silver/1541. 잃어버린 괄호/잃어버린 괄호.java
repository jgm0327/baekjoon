import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        int mul = 1, answer = 0;
        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            if('0' <= ch && ch <= '9'){
                sb.append(ch);
            }else{
                answer += (mul * Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
            }
            if(ch == '-')mul = -1;
        }
        answer += mul * Integer.parseInt(sb.toString());
        System.out.println(answer);
        br.close();
    }
}