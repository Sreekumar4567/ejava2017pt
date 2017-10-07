package ejava.pt.wk1.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@SessionScoped
public class AllRegistration implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject Registration registration;

	private List<Registration> registrations = new LinkedList<>();

	@PostConstruct
	private void init() {
		System.out.println(">>> create all registration");
	}

	@PreDestroy
	private void destroy() {
		System.out.println(">>> destryoing all registration");
	}

	public void add() {
		add(registration);
	}

	public void add(Registration r) {
		registrations.add(r);
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	
}
