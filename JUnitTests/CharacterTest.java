import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.TestCase;

public class CharacterTest extends TestCase{
  int xPos = 5, yPos = 5;
  
  @Test
  public void testCharacterParameters(){
    Character testCharacter = new Weaboo(xPos,yPos);
    assertEquals(this.xPos,testCharacter.getPosition().getX());
    assertEquals(this.yPos,testCharacter.getPosition().getY());
  }
  
  @Test
  public void testMoveUp(){
    Character testCharacter = new Weaboo(xPos,yPos);
    testCharacter.moveUp();
    assertEquals(testCharacter.getPosition().getX(), xPos);
    assertEquals(testCharacter.getPosition().getY(), yPos - 1);
  }
  
  
  @Test
  public void testMoveLeft(){
    Character testCharacter = new Weaboo(xPos,yPos);
    testCharacter.moveLeft();
    assertEquals(testCharacter.getPosition().getX(), xPos - 1);
    assertEquals(testCharacter.getPosition().getY(), yPos);
  }
  
};