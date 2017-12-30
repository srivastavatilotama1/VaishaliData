
/*It’s always recommended to group the same set of 
interceptors into an interceptor stack to get rid of the duplicated works, 
and increase the reusebility in your project

ex

<interceptor-stack name="basicStack">
   <interceptor-ref name="exception"/>
   <interceptor-ref name="servlet-config"/>
   <interceptor-ref name="prepare"/>
   <interceptor-ref name="checkbox"/>
   <interceptor-ref name="params"/>
   <interceptor-ref name="conversionError"/>
</interceptor-stack>



<action name="hello" class="com.tutorialspoint.struts2.MyAction">
   <interceptor-ref name="basicStack"/>
   <result>view.jsp</result>
</action
*/
package com.igate.interceptor;

import java.util.*;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {
	 public void init() {}  
   public String intercept(ActionInvocation invocation)throws Exception{

      /* let us do some pre-processing */
      String output = "Pre-Processing of MyIntercepto"; 
      System.out.println(output);

      /* let us call action or next interceptor */
      String result = invocation.invoke();

      /* let us do some post-processing */
      output = "Post-Processing of MyIntercepto"; 
      System.out.println(output);

      return result;
   }
   public void destroy() {}  
}