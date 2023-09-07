import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    private static int n, d, k, c;
    private static int[] sushi;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        

        n = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        sushi = new int[n + 1];

        for(int i=0 ; i<n ; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(countSushi());
        
        br.close();
    }

    private static int countSushi(){
        int answer = 0;
        int[] count = new int[d + 1];

        for(int i=0 ; i<k ; i++){
            if(count[sushi[i]] == 0)answer++;
            count[sushi[i]]++;
        }
        
        int temp = answer;
        if(count[c] == 0)answer++;

        int start = 0, end = k;
        while(end < n + k){
            count[sushi[start % n]]--;
            if(count[sushi[start % n]] == 0)temp--;
            if(count[sushi[end % n]] == 0)temp++;
            count[sushi[end % n]]++;
            if(count[c] == 0)answer = Math.max(answer, temp + 1);
            else answer = Math.max(answer, temp);
            end++;
            start++;
        }
        return answer;
    }
}