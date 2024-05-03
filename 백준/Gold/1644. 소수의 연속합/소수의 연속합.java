import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(findPrimes(n), n));
    }

    private static List<Integer> findPrimes(int n){
        List<Integer> ret = new ArrayList<>();

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;
        for(int i=2 ; i<=n ; i++){
            if(!primes[i])continue;

            ret.add(i);
            for(int j=i + i ; j<=n ; j += i){
                primes[j] = false;
            }
        }

        return ret;
    }

    private static int solution(List<Integer> primes, int n){
        int ret = 0;

        int left = 0, right = 0, total = 0;

        while(left <= right){
            if(total == n){
                ret++;
            }

            if(total >= n)total -= primes.get(left++);
            else {
                if(right >= primes.size())break;
                total += primes.get(right++);
            }
        }

        return ret;
    }
}