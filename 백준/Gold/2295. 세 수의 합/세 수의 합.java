import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];

        for(int i=0 ; i<n ; i ++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        Map<Integer, Boolean> twoSum = new HashMap<>();

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                twoSum.put(numbers[i] + numbers[j], true);
            }
        }

        solution(twoSum, numbers);

        br.close();
    }

    private static void solution(Map<Integer, Boolean> twoSum, int[] numbers){
        int n = numbers.length;

        for(int i=n-1 ; i>=0 ; i--){
            for(int j=0 ; j<i ; j++){
                int diff = numbers[i] - numbers[j];

                if(twoSum.containsKey(diff)){
                    System.out.println(numbers[i]);
                    return;
                }
            }
        }
    }
}