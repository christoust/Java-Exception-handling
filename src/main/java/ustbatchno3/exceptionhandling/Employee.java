//create employee object with proper validation phone number email id address employee id employee name location salary. use the custom exception to handle the data .Push the data to jdbc.
package ustbatchno3.exceptionhandling;

import ustbatchno3.exceptionhandling.InvalidPhoneNumberException;

public class Employee {
	
	private String phone_no;
	private String email_id;
	private String emp_id;
	private String emp_name;
	private String location;
	private double salary;
	public Employee(String phone_no, String email_id, String emp_id, String emp_name, String location, double salary) throws InvalidPhoneNumberException,InvalidEmailException, InvalidEmpidException {
		super();
		if (emp_name == null || emp_name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");}
        if (phone_no == null || !phone_no.matches("\\d{10}")) {
                throw new InvalidPhoneNumberException("Phone number must be a 10-digit number");
            }
        if (!email_id.contains("@")) {
            throw new InvalidEmailException("email_id is missing '@' symbol");
        }
        if (!email_id.contains(".")) {
            throw new InvalidEmailException("email_id is missing '.' symbol");
        }
        if (email_id.indexOf("@") != email_id.lastIndexOf("@")) {
            throw new InvalidEmailException("email_id contains multiple '@' symbols");
        }
        if(!emp_id.matches("^UST\\d{4}$"))
        {
           throw new InvalidEmpidException("invalid employee id");
        }

		this.phone_no = phone_no;
		this.email_id = email_id;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.location = location;
		this.salary = salary;
	}
	/**
	 * @return the phone_no
	 */
	public String getPhone_no() {
		return phone_no;
	}
	/**
	 * @return the email_id
	 */
	public String getEmail_id() {
		return email_id;
	}
	/**
	 * @return the emp_id
	 */
	public String getEmp_id() {
		return emp_id;
	}
	/**
	 * @return the emp_name
	 */
	public String getEmp_name() {
		return emp_name;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param phone_no the phone_no to set
	 */
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	/**
	 * @param email_id the email_id to set
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	/**
	 * @param emp_name the emp_name to set
	 */
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [phone_no=" + phone_no + ", email_id=" + email_id + ", emp_id=" + emp_id + ", emp_name="
				+ emp_name + ", location=" + location + ", salary=" + salary + "]";
	}

}

