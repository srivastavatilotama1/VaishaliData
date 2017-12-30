
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.17 at 04:56:32 PM IST 
//

package vai.men;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeptType", propOrder = {
    "deptmanager",
    "cost"
})
public class DeptType
{

    @XmlElement(required = true)
    protected String deptmanager;
    protected double cost;
    @XmlAttribute(name = "deptname", required = true)
    protected String deptname;

  
    public String getDeptmanager() {
        return deptmanager;
    }

   
    public void setDeptmanager(String value) {
        this.deptmanager = value;
    }

  
    public double getCost() {
        return cost;
    }

  
    public void setCost(double value) {
        this.cost = value;
    }

  
    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String value) {
        this.deptname = value;
    }

}
