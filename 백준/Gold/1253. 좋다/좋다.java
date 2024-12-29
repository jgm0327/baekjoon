import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		for(int i=0 ; i<n ; i++){
			numbers[i] = Integer.parseInt(tokenizer.nextToken());
		}

        Arrays.sort(numbers);
        
        int answer = 0;
        for(int i=0 ; i<n ; i++) {
        	int left = 0, right = n - 1;
        	while(left < right) {
        		
        		if(left == i)
        			left++;
        		else if(right == i)
        			right--;
        		
        		if(left >= right)
        			break;
        		
        		int total = numbers[left] + numbers[right];
        		
        		
        		if(total == numbers[i]) {
        			answer++;
        			break;
        		}
        		else if(total > numbers[i])
        			right--;
        		else 
        			left++;
        	}
        }
        
        bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}
}