/**
 * ~ Utilities.java
 * Raymond Hruby II
 * 03/13/2017
 * 
 * Util - place for useful but miscellaneous commands
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilities{
  public static String loadFileAsString(String path){
    StringBuilder builder = new StringBuilder();
    
    try{
      BufferedReader br = new BufferedReader(new FileReader(path));
      String line;
        while( (line=br.readLine()) != null){
          builder.append(line + "\n");
        }       
        br.close();               
    }catch(IOException e){
      //e.printStackTrace();
      System.out.println("Utilities | loadFileAsString() fucked up\n");
      System.exit(1);
    }
    return builder.toString();
  }
  
  public static int parseInt(String number){
    try{
      return Integer.parseInt(number);
    }catch(NumberFormatException e){
      //e.printStackTrace();
      System.out.println("Utilities | parseInt() fucked up\n");
      return 0;
    }
  }
}