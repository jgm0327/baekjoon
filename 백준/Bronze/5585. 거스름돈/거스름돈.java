import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = 1000 - Integer.parseInt(br.readLine()), answer = 0;
        int[] changes = {500, 100, 50, 10, 5, 1};

        for(int i=0 ; i<changes.length ; i++){
            answer += money / changes[i];
            money -= money / changes[i] * changes[i];
        }
        System.out.println(answer);
        br.close();
    }
}