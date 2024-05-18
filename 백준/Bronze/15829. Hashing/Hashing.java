import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> index = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0 ; i<26 ; i++){
            index.put((char)('a' + i), i + 1);
        }

        String str = br.readLine();
        long answer = 0;
        for(int i=0 ; i<n ; i++){
            char ch = str.charAt(i);
            answer = (answer + (long)Math.pow(31, i) * index.get(ch));
        }

        System.out.println(answer);

    }
}