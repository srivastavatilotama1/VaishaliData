package bean;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestShow 
{
  public static void main(String[] args) 
  {
  //  ApplicationContext ctx= new ClassPathXmlApplicationContext("audience.xml");
	  ApplicationContext ctx= new ClassPathXmlApplicationContext("bean.xml");
    
    Performer performer = (Performer) ctx.getBean("ZakirHusein");
    performer.perform();
    performer.testMe();
    System.out.println("-----------------------------");
    
   
  }
}
/*
. Pointcuts – Name match example
Intercept a printName() method via ‘pointcut’ and ‘advisor’. Create a NameMatchMethodPointcut pointcut bean, and put the method name you want to intercept in the ‘mappedName‘ property value.
	<bean id="customerPointcut"
        class="org.springframework.aop.support.NameMatchMethodPointcut">
		<property name="mappedName" value="printName" />
	</bean>




2. Pointcut – Regular expression example
You can also match the method’s name by using regular expression pointcut – RegexpMethodPointcutAdvisor.
	<bean id="customerAdvisor"
		class="org.springframework.aop.support.RegexpMethodPointcutAdvisor">
		<property name="patterns">
			<list>
				<value>.*URL.*</value>
			</list>
		</property>
 
		<property name="advice" ref="hijackAroundMethodBeanAdvice" />
	</bean>
Now, it intercepts the method which has words ‘URL’ within the method name. In practice, you can use it to manage DAO layer, where you can declare “.*DAO.*” to intercept all your DAO classes to support transaction.
Download Source Code


*/