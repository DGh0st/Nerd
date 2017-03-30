/**
 * ~ ImageLoader.java
 * Raymond Hruby II
 * 03/30/2017
 * 
 * ImageLoader - encapsulation for ImageIO
 */
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.IOException;
import java.io.File;

public class ImageLoader
{
  public static BufferedImage loadImage(String path){
    try{
      return ImageIO.read(new File(path));
    }catch(IOException e){
      e.printStackTrace();
      System.out.println("ImageLoader | loadImage() Error");
    }
    return null;  //gets rid of errors
  }
}  