import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int bits = 0;
		while(n-- > 0) {
			String[] input = br.readLine().split(" ");
			String command = input[0];
			int num = input.length > 1 ? Integer.parseInt(input[1]) : 0;
			
			if(command.equals("add")) {
				bits = bits | (1 << num);
			}else if(command.equals("check")) {
				int bit = (bits & (1 << num)) >> num;
				bw.write(bit + "\n");
			}else if(command.equals("remove")) {
				bits = bits & ~(1 << num);
			}else if(command.equals("toggle")) {
				if(((bits & (1 << num)) >> num) == 1) {
					bits &= ~(1 << num);
				}else {
					bits = bits | (1 << num);
				}
			}else if(command.equals("empty")){
				bits = 0;
			}else if(command.equals("all")) {
				bits = 0;
				for(int i=1; i <=20 ; i++) {
					bits |= (1 << i);
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
