import java.io.*;
import java.util.*;

class Main {

    private static List<List<Integer>> cases;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int prefix = 0, answer = Integer.MAX_VALUE;
        for(int i=0 ; i<10 ; i++){
            prefix += Integer.parseInt(br.readLine());

            if(Math.abs(100 - answer) >= Math.abs(100 - prefix))
                answer = prefix;
        }

        System.out.println(answer);

        br.close();
    }
}