import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] num = new char[str.length()];
        for(int i=0 ; i<str.length() ; i++){
            num[i] = str.charAt(i);
        }
        Arrays.sort(num);
        StringBuilder sb = new StringBuilder(new String(num));
        
        if(num[0] != '0' || !check(num))System.out.println(-1);
        else System.out.println(sb.reverse());
        br.close();
    }

    private static boolean check(char[] num){
        int ret = 0;
        for(char data : num){
            ret += (int)(data - '0');
        }
        return ret % 3 == 0;
    }
}