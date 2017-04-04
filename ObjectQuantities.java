public class ObjectQuantities
{
static int getMaxStatic(int level){
    int maxStatic;
    switch(level){
      case 0:
        maxStatic = 15;
        break;
      case 1:
        maxStatic = 4;
        break;
      case 2:
        maxStatic = 6;
        break;
      case 3:
        maxStatic = 8;
        break;
      case 4:
        maxStatic = 10;
        break;
      case 5:
        maxStatic = 12;
        break;
      case 6:
        maxStatic = 14;
        break;
      default:
        maxStatic = 10; //placeholder as default
    }
    return maxStatic;
  }

static int getMaxMovables(int level){
    int maxStatic;
    switch(level){
      case 0:
        maxStatic = 0;
        break;
      case 1:
        maxStatic = 8;
        break;
      case 2:
        maxStatic = 10;
        break;
      case 3:
        maxStatic = 12;
        break;
      case 4:
        maxStatic = 14;
        break;
      case 5:
        maxStatic = 16;
        break;
      case 6:
        maxStatic = 18;
        break;
      default:
        maxStatic = 10; //placeholder as default
    }
    return maxStatic;
  }

static int getSpeed(int level){
    int speed;
    switch(level){
      case 0:
        speed = 2;
        break;
      case 1:
        speed = 4;
        break;
      case 2:
        speed = 6;
        break;
      case 3:
        speed = 7;
        break;
      case 4:
        speed = 8;
        break;
      case 5:
        speed = 9;
        break;
      case 6:
        speed = 10;
        break;
      default:
        speed = 2; //placeholder as default
    }
    return speed;
  }


}