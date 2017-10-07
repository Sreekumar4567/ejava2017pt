package ejava.pt.wk1.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class Basket implements Serializable {

	@Inject Item item;

	private static final long serialVersionUID = 1L;

	private List<Item> items = new LinkedList<>();

	public void setItems(List<Item> items) {
		this.items = items;
	}
	public List<Item> getItems() {
		return items;
	}

	public String addToBasket() {
		if (item.getQuantity() <= 0) {
			FacesMessage msg = new FacesMessage("Invalid quantity");
			FacesContext.getCurrentInstance()
					.addMessage("cartForm:quantityField", msg);
			return ("");
		}

		items.add(item.createCopy());
		item.setName("");
		item.setQuantity(0);
		System.out.println(">>> items = " + items);

		return ("basket");
	}

}
