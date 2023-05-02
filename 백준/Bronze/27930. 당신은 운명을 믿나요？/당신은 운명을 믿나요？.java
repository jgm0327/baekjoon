import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		final String korea = "KOREA", yonsei = "YONSEI";
		int idx1 = 0, idx2 = 0;
		for(int i=0 ; i<str.length() ; i++) {
			char ch = str.charAt(i);
			if(korea.charAt(idx1) == ch)idx1++;
			if(yonsei.charAt(idx2) == ch)idx2++;
			if(idx1 == 5 || idx2 == 6)break;
		}
		System.out.println(idx1 == 5 ? "KOREA" : "YONSEI");
		br.close();
	}
	
}
