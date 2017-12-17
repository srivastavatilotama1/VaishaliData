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

import com.cg.dto.Login;
import com.cg.dto.RegisterDto;
import com.cg.service.ILoginService;
import com.cg.util.MyStringDateUtil;

@Controller
public class RegisterController 
{
	@Autowired
	ILoginService loginService;
	ArrayList<String> cityList;
	ArrayList<String>  skillSetList;
	
	@RequestMapping (value="/displayRegisterPage")
	public String showRegisterPage(Model model)
	{
			cityList=new ArrayList<String>();
			cityList.add("Noida");
			cityList.add("Gaziabad");
			cityList.add("Sahibabad");
			cityList.add("Delhi");			
			
			skillSetList=new ArrayList<String>();
			skillSetList.add("C");
			skillSetList.add("C++");
			skillSetList.add("Java");
			skillSetList.add("Unix");
			
			model.addAttribute("skillList", skillSetList);
			model.addAttribute("cList",cityList);		
			model.addAttribute("user",new RegisterDto());
			return "Register";	
	}	
	
	@RequestMapping(value="/insertUserDetails")
	public String insertUserDetails(
			@ModelAttribute("user") @Valid RegisterDto u,
			BindingResult result,
			Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("skillList", skillSetList);
			model.addAttribute("cList",cityList);	
			return "Register";
		}
		System.out.println(" in dao u is ************"+u);
		RegisterDto registerDto=new RegisterDto();
		
		registerDto.setCity(u.getCity());
		registerDto.setDobDateText(u.getDobDateText());
		registerDto.setEmail(u.getEmail());
		registerDto.setFirstName(u.getFirstName());
		registerDto.setGender(u.getGender());
		registerDto.setLastName(u.getLastName());
		registerDto.setUname(u.getUname());		
		registerDto.setSkillSet(u.getSkillSet());
		
		System.out.println("In controller insert ************************"+registerDto);
		
		
		Login userDet=new Login();
		userDet.setPassword(u.getPwd());
		userDet.setUserName(u.getUname());
		
		int noOfRecInsertedLogin=loginService.insertUser(userDet);
		int noOfRecInsertedRegister=loginService.
				insertRegisterUser(registerDto);		
		
		if((noOfRecInsertedLogin==1)&&(noOfRecInsertedRegister==1))
		{
			System.out.println(" inserted....................................");
			List<RegisterDto> userDetailsList=loginService.getAllUsersDetails();
			model.addAttribute("uDetailsList", userDetailsList);
			return "redirect:/displayAllUserInfo.obj";
		}
		else
		{
			return "RegisterFail";
		}
		
	}	
	//********************displayUpdateUserPage Mapping
	
	@RequestMapping(value="displayEditUser",method=RequestMethod.GET)
	public String displayUpdateUserPage(
			@RequestParam("uid") String un,Model model)
	{
		skillSetList=new ArrayList<String>();
		skillSetList.add("C");
		skillSetList.add("C++");
		skillSetList.add("Java");
		skillSetList.add("Unix");
		
		Login userInfo=loginService.getUserDetails(un);
		RegisterDto userDetailInfo=loginService.getRegisterUserDetails(un);
		userDetailInfo.setPwd(userInfo.getPassword());
		System.out.println("**************"+userInfo);
		
		model.addAttribute("newUserDetailUpdate",new RegisterDto());		
		model.addAttribute("UserDetailsObject",userDetailInfo);	
		
		model.addAttribute("skillList", skillSetList);		
		
		return "UpdateUser";
		
	}
	@RequestMapping(value="displayDeleteUser",method=RequestMethod.GET)
	public String deleteUser(@RequestParam("uid") String un,Model model)
	{
		int isDeleted=loginService.deleteUser(un);
		if(isDeleted==1)
		{			
			return "redirect:/displayAllUserInfo.obj";
		}
		return null;
	}
	
	@RequestMapping("updateUser")
	public String updateUserDetails(
			@ModelAttribute("newUserDetailUpdate") RegisterDto u,
			BindingResult result,
			 Model model)
	{
		System.out.println("In controler update ********"+u);
		int rowUserUpdated=loginService.updateUserDetailsInfo(u);
		Login lg=new Login();
		lg.setUserName(u.getUname());
		lg.setPassword(u.getPwd());				
		int rowLoginUpdated=loginService.updateUserInfo(lg);
		if((rowUserUpdated==1)&&(rowLoginUpdated==1))
		{ 	
			System.out.println("both row updated update *********************");
			return "redirect:/displayAllUserInfo.obj";
		}
		return "index";
	}
	
	@RequestMapping("displayAllUserInfo")
	public ModelAndView displayAllUserInfo(ModelAndView modelView)
	{				
			
		List<RegisterDto> userDetailsList=loginService.getAllUsersDetails();
		System.out.println(" in controller ..............display........."+userDetailsList);
		modelView.addObject("uDetailsList", userDetailsList);		
		modelView.setViewName("ListAllUserInfo");	
		return modelView;
	}

}
