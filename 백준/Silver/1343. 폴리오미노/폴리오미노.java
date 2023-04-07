import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder answer;
	private static int cnt;
	private static String input;
	private static final String A = "AAAA", B = "BB";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		answer = new StringBuilder();
		int ret = 0;
		cnt = 0;
		for(int i=0 ; i<input.length() ; i++) {
			if(input.charAt(i) == 'X') {
				cnt++;
			}else if(input.charAt(i) == '.') {
				ret = append(".");
			}
			if(ret == -1) {
				break;
			}
		}
		ret = append("");
		System.out.println(ret != -1 ? answer.toString() : "-1");
		br.close();
	}
	
	private static int append(String ch) {
		for(int j = 0 ; j <cnt/4 ; j++) {
			answer.append(A);
		}
		cnt %= 4;
		if(cnt != 0 && cnt % 2 != 0) {
			return -1;
		}
		for(int j=0 ; j <cnt/2 ; j++) {
			answer.append(B);
		}
		answer.append(ch);
		cnt = 0;
		return 1;
	}
}
