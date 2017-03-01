import java.awt.Dimension;

public class LocationDimension
{
  Dimension dimensions;
  
  public LocationDimension(int width, int height){
    assert dimensionIsNonNegative(width,height);
    dimensions = new Dimension(width,height);  
  }
  
  private boolean dimensionIsNonNegative(int width, int height){
    if(width<0 || height<0){
      return false;
    }
    return true;
  }
  
  //getters and setters below:
  public int getHeight(){
    return (int)dimensions.getHeight(); //returns as double
  }
  public int getWidth(){
    return (int)dimensions.getWidth(); //returns as double
  }
}