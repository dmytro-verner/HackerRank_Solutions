import java.io.*;
import java.util.*;
import java.security.*;
import javax.xml.bind.*;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        
        String message = scanner.nextLine();
        scanner.close();
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(message.getBytes());
        System.out.println(DatatypeConverter.printHexBinary(md.digest()).toLowerCase());     
    }
}