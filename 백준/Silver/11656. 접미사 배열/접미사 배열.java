import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder(br.readLine());
		List<String> list = new ArrayList<>();
		while(str.length() > 0) {
			list.add(str.toString());
			str.deleteCharAt(0);
		}
		Collections.sort(list);
		for(String s : list) {
			System.out.println(s);
		}
		br.close();
	}
}
