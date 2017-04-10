/**
 * ~ OzLocation.java
 * Raymond Hruby II
 * 04/09/2017
 * Test location for use in Oz demonstration
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class OzLocation extends Location{
  int movableTotalRanges = 2; //two ranges(roads) for statics
  int staticTotalRanges = 3; 
  ArrayList< ArrayList<Integer> > staticRanges = new ArrayList< ArrayList<Integer> >();
  ArrayList< ArrayList<Integer> >movableRanges = new ArrayList< ArrayList<Integer> >();
  //ArrayList<Integer> movableRanges = new ArrayList<Integer>(4);
  
  public OzLocation(int id){
    super(id);
    
    ArrayList<Integer> range = new ArrayList<Integer>(2);
    
    //STATIC
    range.add(1);
    range.add(3);    
    staticRanges.add(range);  
    range.add(0,11);
    range.add(1,14);
    staticRanges.add(range);    
    range.add(0,20);
    range.add(1,22);
    staticRanges.add(range);
    /*
    staticRanges.add(1);
    staticRanges.add(3);
    staticRanges.add(11);
    staticRanges.add(14);
    staticRanges.add(20);
    staticRanges.add(22);
    */
    
    //MOVABLE
    range.add(0,5);
    range.add(1,9);
    movableRanges.add(range);    
    range.add(0,16);
    range.add(1,18);
    movableRanges.add(range);
    /*
    movableRanges.add(5);
    movableRanges.add(9);
    movableRanges.add(16);
    movableRanges.add(18);  
    */
  }
  
  public int getMovableTotalRanges(){
    return movableTotalRanges;
  }
  public int getStaticTotalRanges(){
    return staticTotalRanges;
  }
  public ArrayList<Integer> getMovableRange(int range){
    return movableRanges.get(range);
  }
  
  public ArrayList<Integer> getStaticRange(int range){
    return staticRanges.get(range);
  }
  
  
  
}