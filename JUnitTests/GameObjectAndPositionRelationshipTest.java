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
    assertEquals(position.getX(),2);
    assertEquals(position.getY(),2);
    
  }
  
  @Ignore
  @Test
  public void testGameObjectgetFromPositionGet(){
    
    position = new Position();
    //object = position;
    //object.getPosition();
    object = new Weaboo(0, 0);
    assertEquals(object.getPosition().getX(),position.getX());
    assertEquals(object.getPosition().getX(),position.getY());
    
  }
  
}