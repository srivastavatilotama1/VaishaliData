/***************************************************
          SEQUENCE SEQ_APPOINTMENT_ID
***************************************************/

CREATE TABLE doctor_appointment(appointment_id NUMBER(4) PRIMARY KEY






/***************************************************
          TABLE DOCTOR_APPOINTMENT
***************************************************/

 CREATE TABLE doctor_appointment
 (appointment_id NUMBER(4) PRIMARY KEY,
 patient_name VARCHAR2(20),
 phone_number VARCHAR2(10),
 date_of_appointment DATE,
 email VARCHAR2(50),
 age NUMBER(2),
 gender VARCHAR2(6),
 problem_name VARCHAR2(25),
 doctor_name VARCHAR2(25),
 appointment_status VARCHAR2(11));
