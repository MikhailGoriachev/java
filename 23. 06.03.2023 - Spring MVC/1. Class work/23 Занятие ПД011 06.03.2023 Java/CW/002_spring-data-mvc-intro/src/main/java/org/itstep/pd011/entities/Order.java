package org.itstep.pd011.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// элемент заказа
@Entity
@Table(name = "orders")
@Setter
@Getter
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title", length = 65)
	private String title;

	@Column(name = "price")
	private Double price;

	@Override
	public String toString() {
		return "Order [id=" + id + ", title=" + title + ", price=" + price + "]";
	}
}
