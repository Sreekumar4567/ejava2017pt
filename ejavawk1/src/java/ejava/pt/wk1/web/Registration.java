package ejava.pt.wk1.web;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;

	public Registration() { }

	public Registration(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@PostConstruct
	private void init() {
		System.out.println(">>> initializing registration");
	}

	@PreDestroy
	private void destroy() {
		System.out.println(">> destroying: " + name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Registration copy() {
		Registration r = new Registration();
		r.email = email;
		r.name = name;
		return (r);
	}

	@Override
	public String toString() {
		return "Registration{" + "name=" + name + ", email=" + email + '}';
	}

}
