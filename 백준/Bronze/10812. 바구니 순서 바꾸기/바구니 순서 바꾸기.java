import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		List<Integer> list = new ArrayList<>();
		
		int n, m;
		n = Integer.parseInt(size[0]);
		m = Integer.parseInt(size[1]);
		
		for(int i=0 ; i<=n ; i++)
			list.add(i);
		
		while(m-- > 0) {
			String[] values = br.readLine().split(" ");
			int i = Integer.parseInt(values[0]), 
					j = Integer.parseInt(values[1]), 
					k = Integer.parseInt(values[2]);
			
			List<Integer> temp = new ArrayList<>();
			temp.addAll(list.subList(k, j+1));
			temp.addAll(list.subList(i, k));
			
			int idx = i;
			for(int value : temp) {
				list.set(idx++, value);
			}
		}
		for(int data : list.subList(1, n+1)) {
			System.out.print(data + " ");
		}
		br.close();
	}
}
