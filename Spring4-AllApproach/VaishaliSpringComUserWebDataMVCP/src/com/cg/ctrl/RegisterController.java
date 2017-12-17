package com.cg.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bean.Login;
import com.cg.bean.RegisterDto;
import com.cg.service.ILoginService;

import sun.net.RegisteredDomain;

@Controller
public class RegisterController 
{
	@Autowired
	ILoginService loginService;
	
	ArrayList<String> cityList=null;
	ArrayList<String> skillSetList=null;
	@RequestMapping(value="displayRegisterPage")
	public String showRegistrationPage(Model model)
	{
		RegisterDto userObj=new RegisterDto();
		model.addAttribute("user",userObj);
		cityList=new ArrayList<String>();
		//Add City In the Model
		cityList.add("Gaziabad");
		cityList.add("Pune");
		cityList.add("Kolkatta");
		cityList.add("Chennai");		
		model.addAttribute("cList",cityList);
		
		
		skillSetList=new ArrayList<String>();
		skillSetList.add("Java");
		skillSetList.add("C++");
		skillSetList.add("SAP");
		skillSetList.add("DotNet");	
		
		model.addAttribute("skillList",skillSetList);
		
		model.addAttribute("MsgObj","User Does not Exist");
		return "Register";
	}
	//****************************************
	
	@RequestMapping(value="/insertUserDetails")
	public String insertUserDetails(
		@ModelAttribute(value="user")@Valid RegisterDto rd,
		BindingResult result,Model model)
	{
			if(result.hasErrors())
			{
				model.addAttribute("skillList",skillSetList);
				model.addAttribute("cList",cityList);
				return "Register";
			}
	
		System.out.println(" In reg ctrl  rd is : "+rd);
		Login lg=new Login();
		lg.setUserName(rd.getUname());
		lg.setPassword(rd.getPwd());
		System.out.println(" Ctrl*************"+lg);
		
		RegisterDto 	rdd=
				new RegisterDto(rd.getUname(),
						rd.getFirstName(), 
						rd.getLastName(), 
rd.getEmail(), rd.getSkillSet(), rd.getGender(), rd.getCity());
		RegisterDto tempRd=loginService.addAllUserDeatils(rdd);
		Login logDto=loginService.addUser(lg);
		System.out.println(" rd and log  data is Added...."+
		tempRd);
		return "redirect:/displayAllUserInfo.obj";
	}
	
	/*...................displayEditUser..action..................*/
	@RequestMapping(value="displayEditUser",
			method=RequestMethod.GET)
	public String displayUpdateUserPage(
			@RequestParam("uid") String un,Model model)
	{
		skillSetList=new ArrayList<String>();
		skillSetList.add("C");
		skillSetList.add("C++");
		skillSetList.add("Java");
		skillSetList.add("Unix");
		
		Login userInfo=loginService.getUserByUserName(un);
		RegisterDto userDetailInfo=loginService.getRegisterUserDetails(un);
		userDetailInfo.setPwd(userInfo.getPassword());
		System.out.println("**************"+userInfo);
		System.out.println("**************"+userDetailInfo);

		model.addAttribute("newUserDetailUpdate",new RegisterDto());	
		model.addAttribute("UserDetailsObject",userDetailInfo);	
		
		model.addAttribute("skillList", skillSetList);	
		cityList=new ArrayList<String>();
		//Add City In the Model
		cityList.add("Gaziabad");
		cityList.add("Pune");
		cityList.add("Kolkatta");
		cityList.add("Chennai");		
		model.addAttribute("cList",cityList);
		
		
		return "UpdateUser";
		
	}
	
	/**************************Update Users*************/
	 @RequestMapping("updateUser")
	public String updateUserDetails(
			@ModelAttribute("newUserDetailUpdate")  RegisterDto u,
			BindingResult result,
			 Model model)
	{
		System.out.println("In controler update ********"+u);
		
		loginService.updateUserDetailsInfo(u);
		System.out.println("after  update ********"+u);
		Login lg=new Login();
		lg.setUserName(u.getUname());
		lg.setPassword(u.getPwd());	
		System.out.println("In controler update ********"+lg);
		loginService.updateUserInfo(lg);
		//if((rowUserUpdated==1)&&(rowLoginUpdated==1))
		//{ 	
			System.out.println("both row updated update *********************");
			return "redirect:/displayAllUserInfo.obj";
		//}
		//return "index";
	}	 
	 /*****************************List all users**********/
		@RequestMapping("displayAllUserInfo")
		public String displayAllUserInfo(Model model)
		{					
			ArrayList<RegisterDto> uL=loginService.
					getAllUserDetails();			
			model.addAttribute("userListObj", uL);
			return "ListAllUserDetails";
		}

}
