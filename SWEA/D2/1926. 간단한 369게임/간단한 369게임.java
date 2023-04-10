import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=n ; i++) {
			int count = countClap(i);
			StringBuilder tmp = new StringBuilder();
			if(count > 0) {
				for(int j=0 ; j<count ; j++)tmp.append("-");
			}else {
				tmp.append(i);
			}
			tmp.append(" ");
			answer.append(tmp);
		}
		System.out.println(answer.toString());
		br.close();
	}
	
	private static int countClap(int num) {
		int cnt = 0;
		while(num > 0) {
			int n = num % 10;
			if(n == 3 || n == 6 || n == 9)cnt++;
			num /= 10;
		}
		return cnt;
	}
}
