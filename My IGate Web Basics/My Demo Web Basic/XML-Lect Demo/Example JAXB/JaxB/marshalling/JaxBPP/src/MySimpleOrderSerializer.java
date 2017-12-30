import java.io.File;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import vai.men.*;

public class MySimpleOrderSerializer 
{
	private static final String BOOKSTORE_XML = "./companystore-jaxb.xml";
	public static void main(String[] args) throws Exception 
	{
		Company.CompanyAddress compAddress=new Company.CompanyAddress();

		compAddress.setCity("PUNE");
		compAddress.setName("Vinsys It Services");
		compAddress.setPhnum("88888");
		compAddress.setState("MS");
		compAddress.setStreet("Karve Road");
		compAddress.setZipcode("4049090");	

		DeptType deptType1=new DeptType();
		deptType1.setDeptname("Account");
		deptType1.setDeptmanager("swapnil");
		deptType1.setCost(2000);	 
		
		DeptType deptType2=new DeptType();
		deptType2.setDeptname("IT");
		deptType2.setDeptmanager("Rahul");
		deptType2.setCost(3000);	 
		
		

		Company.Departments departments=new  Company.Departments();
		List<DeptType> deptList=departments.getDepartment();
		deptList.add(deptType1);
		deptList.add(deptType2);
		

		Company company=new Company();
		company.setCompanyAddress(compAddress );
		company.setDepartments(departments);
		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(Company.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		//m.setProperty(Marshaller.JAXB_ENCODING,Boolean.TRUE);
		//	m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,Boolean.FALSE);


		// Write to System.out
		m.marshal(company, System.out);

		// Write to File
		m.marshal(company, new File(BOOKSTORE_XML));

		// get variables from our xml file, created before
		System.out.println();
		System.out.println("Output from our XML File: ");

	}

}
