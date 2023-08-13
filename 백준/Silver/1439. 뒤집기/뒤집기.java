import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    public static void main(String... args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] count = new int[2];

        char comp = str.charAt(0);
        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            int num = (int)(comp - '0');
            if(comp != ch){
                count[num]++;
                comp = ch;
            }
            if(i == str.length() - 1){
                count[(int)(comp - '0')]++;
            }
        }
        System.out.println(Math.min(count[0], count[1]));
        br.close();
    }
}