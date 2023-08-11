import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int[] timer = {300, 60, 10};
        int n = Integer.parseInt(br.readLine());

        String str = "";
        for(int i=0 ; i<3 ; i++){
            str += (n / timer[i] +" ");
            n -= n / timer[i] * timer[i];
        }

        if(n == 0)System.out.println(str);
        else System.out.println(-1);

        br.close();
    }
}