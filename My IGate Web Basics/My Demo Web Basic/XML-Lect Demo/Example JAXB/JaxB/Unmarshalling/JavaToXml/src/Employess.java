import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="emps",namespace="com.emp.vinsys")
@XmlType(name="empsType",propOrder={"empList"})
public class Employess
{
	@XmlElement( name="emp",required=true)
	private List<Employee> empList;

	public List<Employee> getEmpList() 
	{
		return empList;
	}

	public void setEmpList(List<Employee> empList)
	{
		this.empList = empList;
	}

	

}
