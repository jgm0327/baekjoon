import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		Set<Integer> set = new HashSet<>();
		for(String str : br.readLine().split(" ")) {
			set.add(Integer.parseInt(str));
		}
		Integer[] arr = set.toArray(Integer[]::new);
		Arrays.sort(arr);
		for(int data : arr) {
			System.out.println(data);
		}
		br.close();
	}
}
