/************************8KEEP HERE AND DONT UPDATE***************************
 * ~ AssetsLoader
 * Raymond Hruby II
 * 03/06/2017
 * AssetsLoader - picks path to spritesheet based on location id
 */

public class AssetsLoader
{
  public static String getAssetsPath(int id){
    String path;
    switch(id){
      case 0:
        path = "./resources/textures/SpriteSheet01.png"; 
        break;
      case 1:
        path = "./resources/textures/SpriteSheet02.png"; //generic location for the sheet
        break;
      case 2:
        path = "./resources/textures/SpriteSheet03.png"; //generic location for the sheet
        break;
      case 3:
        path = "./resources/textures/SpriteSheet04.png"; //generic location for the sheet
        break;
      case 4:
        path = "./resources/textures/SpriteSheet05.png"; //generic location for the sheet
        break;
      case 5:
        path = "./resources/textures/SpriteSheet06.png"; //generic location for the sheet
        break;
      case 6:
        path = "./resources/textures/SpriteSheet07.png"; //generic location for the sheet
        break;
      default:
        path = "./resources/textures/SpriteSheet01.png"; //placeholder as default
    }
    return path;
  }
  public static String getLocationPath(int id){
    String path;
    switch(id){
      case 0:
        path = "./resources/locations/Location01.txt"; 
        break;
      case 1:
        path = "./resources/locations/Location02.txt";
        break;
      case 2:
        path = "./resources/locations/Location03.txt"; 
        break;
      case 3:
        path = "./resources/locations/Location04.txt"; 
        break;
      case 4:
        path = "./resources/locations/Location05.txt";
        break;
      case 5:
        path = "./resources/locations/Location06.txt"; 
        break;
      case 6:
        path = "./resources/locations/Location07.txt";  
        break;
      default:
        path = "./resources/locations/Location01.txt"; //placeholder as default
    }
    return path;
  }
}