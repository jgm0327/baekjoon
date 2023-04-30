import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	public class Main {
		private static StringBuilder builder;
		private static String str;
		public static void main(String[] args) throws IOException{
			init();
			solution();
		}
		
		private static void init() throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			builder = new StringBuilder();
			str = br.readLine();
			br.close();
		}
		
		private static void solution() {
			final char[] order = {'U', 'C', 'P', 'C'};
			int idx = 0;
			for(int i=0 ; i<str.length() ; i++) {
				char ch = str.charAt(i);
				if(order[idx] == ch) {
					builder.append(ch);
					idx++;
				}
				if(builder.length() == 4)break;
			}
			System.out.println(builder.length() == 4 ? "I love UCPC" : "I hate UCPC");
		}
		
}
