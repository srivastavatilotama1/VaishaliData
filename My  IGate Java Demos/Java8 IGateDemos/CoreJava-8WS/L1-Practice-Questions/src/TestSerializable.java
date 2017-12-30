import java.io.*;
 class A  implements Serializable 
{public A() {
	
        System.out.println("in side A Constructor");
 }}
 class B extends A
{public B() {
        System.out.println("in side Constructor B");       
 }}

public class TestSerializable 
{	
	public static void main(String...args)throws Exception 
	{
			B b = new B();
			ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("datafile"));
			save.writeObject(b); 
			save.flush();   
			ObjectInputStream restore = new ObjectInputStream(new FileInputStream("datafile"));
			B z = (B) restore.readObject();  
			
}}





