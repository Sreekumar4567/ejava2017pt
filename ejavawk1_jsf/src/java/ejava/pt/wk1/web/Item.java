package ejava.pt.wk1.web;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Integer quantity;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Item createCopy() {
		Item i = new Item();
		i.name = name;
		i.quantity = quantity;
		return (i);
	}

	@Override
	public String toString() {
		return "Item{" + "name=" + name + ", quantity=" + quantity + '}';
	}
}
