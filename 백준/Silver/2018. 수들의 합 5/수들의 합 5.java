import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=1 ; i<n ; i++){
            arr[i] = i;
        }

        int start = 1, end = 1, answer = 1, total = 0;

        while(true){
            if(total >= n)total -= arr[start++];
            else if(end >= n)break;
            else total += arr[end++];
            if(total == n)answer++;
        }
        System.out.println(answer);
        sc.close();
    }
}