import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

class MazeLoader{
  
  public static void loadMaze(String mazePath, StaticObstacle[] cone)  throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(mazePath),
        Charset.forName("UTF-8")));
    int s;
    int i=0;
    while ((s = reader.read()) != -1) {
      for(int y=0; y<LocationArray.getInstance().getCurrentLocation().getHeight(); y++){
      for(int x=0; x<LocationArray.getInstance().getCurrentLocation().getWidth(); x++){
        if ((char) s == '*'){
        cone[i] = new Cone(x,y);
        //LocationArray.getInstance().getCurrentLocation().addStatic(cone[i]);
        i++;
        } 
      }
    }
      
      
      
      
    }
  }
}