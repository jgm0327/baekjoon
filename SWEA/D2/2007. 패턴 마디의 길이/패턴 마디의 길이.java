import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1 ; t<=T ; t++) {
			int answer = 0;
			String paragraph = br.readLine();
			
			for(int i=1 ; i<11 ; i++) {
				if(paragraph.substring(0, i).equals(paragraph.substring(i, 2*i))) {
					answer = i;
					break;
				}
			}
			
			System.out.println(String.format("#%d %d", t, answer));
		}
		br.close();
	}
}
