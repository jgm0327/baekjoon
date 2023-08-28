import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main{

    private static List<Integer> primes;
    private static boolean[] isPrime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        primes = new ArrayList<>();
        isPrime = new boolean[n + 1];
        findPrimes(n);

        int start = 0, end = 0, total = 0, answer = !isPrime[n] ? 1 : 0;
        while(!primes.isEmpty()){
            if(start <= end && total >= n){
                if(total == n)answer++;
                total -= primes.get(start++);
            }
            else if(end == primes.size() - 1)break;
            else total += primes.get(end++);
        }
        System.out.println(answer);
        sc.close();
    }

    private static void findPrimes(int n){
        isPrime[1] = true;
        for(int i=2 ; i<=n ; i++){
            if(isPrime[i])continue;
            primes.add(i);
            for(int j=i+i ; j<=n ; j+=i){
                isPrime[j] = true;
            }
        }
    }
}