import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        int parent = 1, child = 1, line = 1, count = 1;
        
        while(X-- > 1){
            if(line == count){
                line++;
                count = 1;
                if(line % 2 == 1){
                    child++;
                }
                else{
                    parent++;
                }
                continue;
            }

            if(line % 2 == 0){
                child++;
                parent--;
            }
            else{
                child--;
                parent++;
            }
            count++;
        }

        System.out.printf("%d/%d", child, parent);
    }
}