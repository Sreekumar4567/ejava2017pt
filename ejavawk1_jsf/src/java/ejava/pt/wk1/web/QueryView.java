package ejava.pt.wk1.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.sql.DataSource;

@RequestScoped
@Named
public class QueryView {

	private static final String FIND_BY_ID = "select * from CUSTOMER where CUSTOMER_ID = ?";

	@Resource(lookup = "jdbc/ejava") DataSource ds;

	private Integer customerId;
	private Customer customer = null;

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void query() {

		if (customerId == null)
			return;

		FacesMessage msg;
		System.out.println(">> customer id = " + customerId);
		try (Connection conn = ds.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(FIND_BY_ID);
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				customer = Customer.populate(rs);

			else {

				customer = null;
				msg = new FacesMessage(String.format(
						"Customer not found: %d", customerId));
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}

		} catch (SQLException ex) {

			msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, 
					ex.getMessage(), ex.getSQLState());
			FacesContext.getCurrentInstance().addMessage(null, msg);

		}
	}
	
}
