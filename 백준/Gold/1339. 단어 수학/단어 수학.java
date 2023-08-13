import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main{
    public static void main(String... args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[26][2];
        String[] str = new String[n];

        for(int t = 0 ; t < n ; t++){
            str[t] = br.readLine();
            int len = str[t].length();
            for(int i=0 ; i<len ; i++){
                int idx = (int)(str[t].charAt(i) - 'A');
                arr[idx][0] = idx;
                arr[idx][1] += Math.pow(10, (len - i));
            }
        }

        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);
        Map<Character, Integer> number = new HashMap<>();

        int cnt = 9;
        for(int i=0 ; i<26 ; i++){
            char ch = (char)(arr[i][0] + 'A');
            if(number.containsKey(ch))continue;
            number.put(ch, cnt--);
        }

        int answer = 0;
        for(int i=0 ; i<n ; i++){
            String num = "";
            for(int j=0 ; j<str[i].length() ; j++){
                num += number.get(str[i].charAt(j));
            }
            answer += Integer.parseInt(num);
        }
        System.out.println(answer);
        br.close();
    }
}