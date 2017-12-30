import java.awt.*;
import java.applet.*;
public class MyJava extends Applet
{
  public void sayHello() 
  {
    Graphics g = getGraphics();
    g.drawString("Hello from JAVA!", 10, 10);
    }
}