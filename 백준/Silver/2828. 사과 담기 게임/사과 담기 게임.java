import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        int m = Integer.parseInt(str[1]);

        int j = Integer.parseInt(br.readLine());

        int start = 1, end = m;
        int answer = 0;
        while(j-- > 0){
            int number = Integer.parseInt(br.readLine());

            if(start <= number && number <= end)
                continue;

            if(number < start){
                answer += start - number;
                start = number;
                end = start + m - 1;
            }
            else{
                answer += number - end;
                end = number;
                start = end - m + 1;
            }
        } 

        System.out.println(answer);

        br.close();
    }
}