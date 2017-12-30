
public class Person 
{
int age;
String name;
public int getAge() 
{
	return age;
}
public void setAge(int age)
{
	this.age = age;
}
public String getName() 
{
	return name;
}
public void setName(String name)
{
	this.name = name;
}
public Person(String name,int age)
{
	super();
	this.age = age;
	this.name = name;
}
@Override
public String toString() 
{
	return "Person [age=" + age + ", name=" + name + "]";
}

}
