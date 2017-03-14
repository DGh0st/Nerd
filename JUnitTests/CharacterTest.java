import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.TestCase;

public class CharacterTest extends TestCase{
  Character testCharacter, testCharacter1, testCharacter2, testCharacter3, testCharacter4;
  int xPos = 5, yPos = 5;
  
  @Ignore
  @Test
  public void testCharacterParameters(){
    testCharacter = new Weaboo(xPos,yPos);
    assertEquals(this.xPos,testCharacter.xPos);
    assertEquals(this.yPos,testCharacter.yPos);
  }
  
  @Ignore
  @Test
  public void testMoveUp(){
    testCharacter1 = new Weaboo(1,1);
    assertEquals(testCharacter1.xPos, 1);
    assertEquals(testCharacter1.yPos, 1);
  }
  
  
  @Ignore
  @Test
  public void testMoveLeft(){
    testCharacter3 = new Weaboo(1,1);
    testCharacter3.moveLeft();
    assertEquals(testCharacter3.xPos, 1);
    assertEquals(testCharacter3.yPos, 1);
  }
  
};