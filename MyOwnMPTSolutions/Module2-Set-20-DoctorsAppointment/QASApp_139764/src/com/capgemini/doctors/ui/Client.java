package com.capgemini.doctors.ui;

import java.util.Scanner;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.service.DoctorAppointmentService;
import com.capgemini.doctors.service.DoctorAppointmentServiceImpl;
import com.capgemini.doctors.exception.DoctorException;

public class Client {
	static DoctorAppointment bean = new DoctorAppointment();
	static DoctorAppointmentService service = new DoctorAppointmentServiceImpl();
	static DoctorAppointmentServiceImpl serviceImpl = new DoctorAppointmentServiceImpl();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int num = 0;
		while (num < 3) {
			System.out.println("\n***************************"
					+ "\n1.Book Doctor Appointment"
					+ "\n2.View Doctor Appointment" + "\n3.Exit"
					+ "\n***************************" + ""
					+ "\nEnter your choice: ");
			num = sc.nextInt();
			int appointmentId = 0;

			switch (num) {
			case 1:
				try {
					bean = addPatientDetails();
				} catch (Exception e1) {
					System.out.println("Unable to insert " + e1);
				}
				break;
			case 2:
				System.out.println("Enter the appointment id    : ");
				appointmentId = sc.nextInt();
				try {
					if (serviceImpl.isValidAppointmentId(String
							.valueOf(appointmentId))) {
						bean = service
								.getDoctorAppointmentDetails(appointmentId);
						System.out.println(bean);
					} else {
						throw new DoctorException("Not able to view details");
					}
				} catch (DoctorException e) {
					System.out.println(e);
				}
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		sc.close();

	}

	
	// ------------------------ QAS Application --------------------------
		/*******************************************************************************************************
		 * - Function Name : addPatientDetails() 
		 * - Input Parameters : - 
		 * - Return Type : DoctorAppointment 
		 * - Throws : DoctorException 
		 * - Author : PRASEEDA 
		 * - Creation Date : 30/11/2017 
		 * - Description : Takes the patient details from user and validates it
		 ********************************************************************************************************/

	private static DoctorAppointment addPatientDetails() {
		try {
			System.out.println("Enter name of the patient    : ");
			String patientName = sc.next();
			sc.nextLine();
			if (serviceImpl.isValidName(patientName)) {
				bean.setPatientName(patientName);
				System.out.println("Enter Phone Number           : ");
				long phNumber = sc.nextLong();
				if (serviceImpl.isValidPhNumber(phNumber)) {
					bean.setPhNumber(phNumber);
					System.out.println("Enter Email                  : ");
					String emailId = sc.next();
					if (serviceImpl.isValidEmail(emailId)) {
						bean.setEmailId(emailId);
						System.out.println("Enter Age                    : ");
						int patientAge = sc.nextInt();
						if (serviceImpl.isValidAge(patientAge)) {
							bean.setPatientAge(patientAge);
							System.out
									.println("Enter Gender                 : ");
							String gender = sc.next();
							if (serviceImpl.isValidGender(gender)) {
								bean.setGender(gender);
								System.out
										.println("Enter Problem Name           : ");
								String problemName = sc.next();
								if (serviceImpl.isValidName(problemName)) {
									bean.setProblemName(problemName);
									service.addDoctorAppointmentDetails(bean);
								} else
									throw new DoctorException(
											"Patient Name should start from Capital Letter");
							} else
								throw new DoctorException(
										"Gender should be like 'female' or 'female'");
						} else
							throw new DoctorException(
									"Age should be in minimum 2 digit");
					} else
						throw new DoctorException(
								"Email Id should be valid without capital letters and special symbols");
				} else
					throw new DoctorException(
							"Phone number should be 10 digit starting from 7,8 or 9");
			} else
				throw new DoctorException(
						"Patient Name should start with capital letter");

		} catch (DoctorException e) {
			System.out.println(e);
		}
		return bean;
	}

}
