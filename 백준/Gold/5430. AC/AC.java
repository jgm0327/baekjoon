import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			ArrayDeque<String> list = new ArrayDeque<>();
			String[] numbers = str.substring(1, str.length()-1).split(",");
			
			for(String number : numbers) {
				list.add(number);
			}

			boolean reversed = false, error = false;
			
			for(int i=0 ; i<command.length() ; i++) {
				char ch = command.charAt(i);
				if(ch == 'R') {
					reversed = reversed ? false : true;
				}
				else if(ch == 'D') {
					// 비어 있는데 삭제하려고 하면 오류
					if(list.size() == 0 || n == 0) {
						error = true;
						break;
					}
					if(reversed)list.pollLast();
					else list.pollFirst();
				}
			}
			
			StringBuilder sb = new StringBuilder();
			if(error) sb.append("error\n");
			else {
				sb.append("[");
				Iterator<String> it;
				if(reversed)it = list.descendingIterator();
				else it = list.iterator();
				while(it.hasNext()) {
					sb.append(it.next());
					if(it.hasNext())sb.append(",");
				}
				sb.append("]\n");
			}
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
