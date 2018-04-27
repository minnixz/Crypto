import java.awt.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.io.*;

class main {
    public static void main(String[] args) {
        
    int inputCode = 5547;
    
    System.out.println("Orginial Number: "+inputCode);
    System.out.println("Encrypted Number: "+encryption(inputCode,"Encrypt"));
    System.out.println("Decrypted Number: "+ encryption(encryption(inputCode,"Encrypt"),"Decrypt"));
    
    }
    
    public static String encryptCharacter(String inputCharacter){
        int inputInt = Integer.parseInt(inputCharacter);
        inputInt += 7;
        inputInt = inputInt%10;
        return Integer.toString(inputInt);
    }
    public static String unencryptCharacter(String inputCharacter){
        int inputInt = Integer.parseInt(inputCharacter);
        inputInt =  (inputInt - 7 + 10) % 10;
        return Integer.toString(inputInt);
    }
    public static int encryption(int inputNumber, String EncryptOrDecrypt){
        //put number into string
        String inputString = Integer.toString(inputNumber);
        
       //Create string array the length of inputString
        String[] stringArray = new String[inputString.length()];
        
        //bring each character into string array while encrypting or decrypting character
        for(int i = 0;i<stringArray.length;i++){
            if(EncryptOrDecrypt == "Decrypt"){
                stringArray[i]=unencryptCharacter(inputString.substring(i,i+1));
            }
            else if (EncryptOrDecrypt == "Encrypt"){
                stringArray[i]=encryptCharacter(inputString.substring(i,i+1));
            }
            
         }
        //create duplicate array and swap values
        String[] outputStringArray = new String[inputString.length()];
        outputStringArray[0] = stringArray[2];
        outputStringArray[1] = stringArray[3];
        outputStringArray[2] = stringArray[0];
        outputStringArray[3] = stringArray[1];
        
        //combine string array into string
        String outputString = "";
        for(int i = 0; i < outputStringArray.length;i++){
            outputString = outputString.concat(outputStringArray[i]);
        }
        
        //output string as int
        return Integer.parseInt(outputString);
        
    }
    
    
}