package 백준.단어의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();

        String[]splits = line.split(" ");
        if(splits[0].equals("")){
            System.out.println(0);
        }else {
            System.out.println(splits.length);
        }

    }
}
