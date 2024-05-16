import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());       

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());

        int[] lectures = new int[n];
        for(int i=0 ; i<n ; i++){
            lectures[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int left = 1, right = 1000000000;

        int answer = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;

            int total = 0, cnt = 1;
            for(int lecture : lectures){
                if(lecture > mid){
                    cnt = m + 1;
                    break;
                }
                total += lecture;

                if(total <= mid)continue;

                total = lecture;
                cnt++;
            }

            if(cnt > m){
                left = mid + 1;
            }else{
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

}