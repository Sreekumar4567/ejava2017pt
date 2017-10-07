package ejava.pt.wk1.web;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {

	private Integer customerId;
	private String name;
	private String address;
	private String city;
	private String state;
	private String phone;
	private String email;

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public static Customer populate(ResultSet rs)
			throws SQLException {
		Customer c = new Customer();
		c.setCustomerId(rs.getInt("CUSTOMER_ID"));
		c.setAddress(rs.getString("ADDRESSLINE1"));
		c.setCity(rs.getString("CITY"));
		c.setEmail(rs.getString("EMAIL"));
		c.setName(rs.getString("NAME"));
		c.setPhone(rs.getString("PHONE"));
		c.setState(rs.getString("STATE"));
		return (c);
	}
	
}
