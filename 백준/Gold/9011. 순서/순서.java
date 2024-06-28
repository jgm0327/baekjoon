import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder answer = new StringBuilder();

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());

            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            for(int i=0 ; i<n ; i++){
                arr[i] = Integer.parseInt(tokenizer.nextToken());
            }

            boolean isImpossible = false;
            boolean[] visit = new boolean[n + 1];
            int[] numbers = new int[n];

            for(int i=n - 1 ; i >= 0 ; i--){
                if(i < arr[i]){
                    isImpossible = true;
                    break;
                }

                if(i == arr[i]){
                    for(int j=n ; j >= arr[i] ; j--){
                        if(visit[j])
                            continue;

                        visit[j] = true;
                        numbers[i] = j;
                        break;
                    }

                    continue;
                }

                isImpossible = true;
                
                int cnt = 0;
                for(int j=1 ; j<=n ; j++){
                    if(visit[j])
                        continue;

                    if(++cnt >= arr[i] + 1){
                        numbers[i] = j;
                        visit[j] = true;
                        isImpossible = false;
                        break;
                    }
                }
            }

            if(isImpossible){
                answer.append("IMPOSSIBLE\n");
                continue;
            }

            for(int i=0 ; i<n ; i++){
                answer.append(numbers[i]).append(" ");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}