import java.util.Scanner;

class Main{
    private static int answer, n, num, len;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        len = str[0].length();
        num = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);
        arr = new int[n];

        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        
        answer = 0;
        recur(0, new StringBuilder());
        System.out.println(answer);
        sc.close();
    }

    private static void recur(int depth, StringBuilder sb){
        if(depth == len){
            return;
        }

        for(int i=0 ; i<n ; i++){
            sb.append(arr[i]);
            int temp = Integer.parseInt(sb.toString());
            if(temp <= num){
                answer = Math.max(answer, temp);
            }
            recur(depth + 1, sb);
            sb.deleteCharAt(depth);
        }
    }
}