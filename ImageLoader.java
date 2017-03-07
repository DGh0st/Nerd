/**
 * ~ ImageLoader.java
 * Raymond Hruby II
 * 03/06/2017
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
      //return ImageIO.read(ImageLoader.class.getResource(path));
      return ImageIO.read(new File(path));
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1); //exits everything
    }
    return null;  //gets rid of errors
  }
}  