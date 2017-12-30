package roseindia.net.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import roseindia.net.model.Student;
import roseindia.net.service.AppService;



@SuppressWarnings("deprecation")
public class StudentFormController extends SimpleFormController 
{
	
	AppService appService;
	
	public AppService getAppService()
	{
		return appService;
	}
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	@Override
	protected ModelAndView onSubmit(Object command) throws ServletException 
	{
		System.out.println("student form controller**on submit****************************************");
		Student stu = (Student) command;		
		appService.addStudent(stu);
		ModelAndView modelAndView = new ModelAndView("student/regiSuccess","stu",stu);		
		return modelAndView;		
    }
	
	
	protected Map referenceData(HttpServletRequest request) throws Exception 
	{
		System.out.println("student form controller*****reference data*******************************");
		Map referenceData = new HashMap();
		referenceData.put("courses", appService.getAllCourses());
		return referenceData;
	}
	
	

}
