import MyPkg.BaseWidget;
import MyPkg.TypeAWidget;


public class DownCast
{
public static void main(String args[])
{
	BaseWidget B = new BaseWidget(); 
	TypeAWidget A = B.upgrade();
}
}
