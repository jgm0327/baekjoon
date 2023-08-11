import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] count = new int[2];
        int comp = (int)(str.charAt(0) - '0');

        for(int i=0 ; i<str.length() ; i++){
            int num = (int)(str.charAt(i) - '0');
            if(num != comp){
                count[comp]++;
                if(i == str.length() - 1)count[num]++;
                comp = num;
            }
            else if(i == str.length() - 1){
                count[comp]++;
            }
        }
        System.out.println(Math.min(count[0], count[1]));
        br.close();
    }
}