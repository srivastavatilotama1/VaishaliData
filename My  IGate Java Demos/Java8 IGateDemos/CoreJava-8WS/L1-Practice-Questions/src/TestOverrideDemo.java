import java.io.File;

class Grandparent 
{
    String name = "granparent";
    void act() 
    {
        System.out.println(name);
    }
}

class Parent1 extends Grandparent
{
    String name = "parent";
    }

class Child1 extends Parent1 
{
    String name = "child";
    void act()
    {
        System.out.println(name);
    }
}
public class TestOverrideDemo
{
    public static void main(String[] args) 
    {
        Parent1 yo = new Parent1();
        yo.act();
        Grandparent gp= new Grandparent();
        gp.act();
        Grandparent pp= new Parent1();
        pp.act();
       
       
    }
}



