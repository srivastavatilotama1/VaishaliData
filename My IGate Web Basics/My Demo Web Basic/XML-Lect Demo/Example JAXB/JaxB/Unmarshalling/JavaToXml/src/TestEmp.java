import java.io.File;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


public class TestEmp 
{
	private static final String EMP_XML = "./emp.xml";
	public static void main(String[] args) throws Exception 
	{
		
		EmpNameType empName1=new EmpNameType();
		empName1.setFname("Vaishali");
		empName1.setMname("Abhi");
		empName1.setLname("Srivastava");
		
		
		Employee vaiE=new Employee();
		vaiE.setGen('F');
		vaiE.setEmpNameType(empName1);
		vaiE.setId(386);
		vaiE.setSal(200000);
		
		EmpNameType empName2=new EmpNameType();
		empName2.setFname("Umesh");
		empName2.setMname("N");
		empName2.setLname("Bahir");
		
		
		Employee umeshE=new Employee();
		umeshE.setGen('M');
		umeshE.setEmpNameType(empName2);
		umeshE.setId(222);
		umeshE.setSal(100000);
		
		Employess emps=new Employess();
		
		ArrayList empList=new ArrayList();
		empList.add(vaiE);
		empList.add(umeshE);
		
		emps.setEmpList(empList);
		
		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(Employess.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		//m.setProperty(Marshaller.JAXB_ENCODING,Boolean.TRUE);
		//	m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,Boolean.FALSE);


		// Write to System.out
		m.marshal(emps, System.out);

		// Write to File
		m.marshal(emps, new File(EMP_XML));

		// get variables from our xml file, created before
		System.out.println();
		System.out.println("Output from our XML File: ");

	}

}
