import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
	public class Main {
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int n = Integer.parseInt(br.readLine());
			
			Map<String, Boolean> map = new HashMap<>();
			for(int i=0 ; i<n ; i++) {
				String[] str = br.readLine().split(" ");
				String name = str[0], command = str[1];
				if(command.equals("leave")) {
					map.remove(name);
				}else if(command.equals("enter")) {
					map.put(name, true);
				}
			}
			
			List<String> answer = new ArrayList<>(map.keySet());
			Collections.sort(answer);
			
			for(int i=answer.size() - 1 ; i >= 0 ; i--) {
				System.out.println(answer.get(i));
			}
			
			bw.flush();
			bw.close();
			br.close();
		}
}
