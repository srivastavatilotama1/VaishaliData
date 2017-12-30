package vai.men;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "companyAddress",
    "departments"
})
@XmlRootElement(name = "Company")
public class Company {

    @XmlElement(name = "CompanyAddress", required = true)
    protected Company.CompanyAddress companyAddress;
    @XmlElement(required = true)
    protected Company.Departments departments;

    /**
     * Gets the value of the companyAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Company.CompanyAddress }
     *     
     */
    public Company.CompanyAddress getCompanyAddress() {
        return companyAddress;
    }

    /**
     * Sets the value of the companyAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company.CompanyAddress }
     *     
     */
    public void setCompanyAddress(Company.CompanyAddress value) {
        this.companyAddress = value;
    }

    /**
     * Gets the value of the departments property.
     * 
     * @return
     *     possible object is
     *     {@link Company.Departments }
     *     
     */
    public Company.Departments getDepartments() {
        return departments;
    }

    /**
     * Sets the value of the departments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company.Departments }
     *     
     */
    public void setDepartments(Company.Departments value) {
        this.departments = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "street",
        "city",
        "state",
        "zipcode",
        "phnum"
    })
    public static class CompanyAddress 
    {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected String street;
        @XmlElement(required = true)
        protected String city;
        @XmlElement(required = true)
        protected String state;
        @XmlElement(required = true)
        protected String zipcode;
        @XmlElement(required = true)
        protected String phnum;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the street property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStreet() {
            return street;
        }

        /**
         * Sets the value of the street property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStreet(String value) {
            this.street = value;
        }

        /**
         * Gets the value of the city property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCity() {
            return city;
        }

        /**
         * Sets the value of the city property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCity(String value) {
            this.city = value;
        }

        /**
         * Gets the value of the state property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getState() {
            return state;
        }

        /**
         * Sets the value of the state property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setState(String value) {
            this.state = value;
        }

        /**
         * Gets the value of the zipcode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZipcode() {
            return zipcode;
        }

        /**
         * Sets the value of the zipcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZipcode(String value) {
            this.zipcode = value;
        }

        /**
         * Gets the value of the phnum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPhnum() {
            return phnum;
        }

        /**
         * Sets the value of the phnum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPhnum(String value) {
            this.phnum = value;
        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "department"
    })
    public static class Departments
    {

        @XmlElement(required = true)
        protected List<DeptType> department;

        public List<DeptType> getDepartment() {
            if (department == null) {
                department = new ArrayList<DeptType>();
            }
            return this.department;
        }

    }

}
