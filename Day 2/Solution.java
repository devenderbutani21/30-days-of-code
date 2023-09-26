import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        String regex = "<(.+?)>([^<>]+)</(\\1)>";
        Pattern p = Pattern.compile(regex);

        Scanner input = new Scanner(System.in);
        int i = Integer.parseInt(input.nextLine());
        while (i>0) {
            String str = input.nextLine();
            Matcher m = p.matcher(str);

            boolean found = false;

            while (m.find()) {
                System.out.println(m.group(2));
                found = true;
            }

            if (!found) {
                System.out.println("None");
            }
            
            i--;
        }
        
        input.close(); 
    }
}
