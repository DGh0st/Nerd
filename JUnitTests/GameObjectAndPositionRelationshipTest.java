import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.TestCase;

public class GameObjectAndPositionRelationshipTest extends TestCase{
  Position position;
  GameObject object;
  int xPos = 0, yPos = 0;
  
  @Ignore
  @Test
  public void testPositionSetToGameObjectSet(){
    
    position = new Position();
    position.setPosition(2,2);
    assertEquals(object.xPos,2);
    assertEquals(object.yPos,2);
    
  }
  
  @Ignore
  @Test
  public void testGameObjectgetFromPositionGet(){
    
    position = new Position();
    object = position;
    object.getPosition();
    assertEquals(object.getPosition[0],position.x);
    assertEquals(object.getPosition[1],position.y);
    
  }
  
}