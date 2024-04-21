package org.jsp.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String itemName;
private String address;
private double price;
@CreationTimestamp
private LocalDate order_Time;
@UpdateTimestamp
private LocalDate del_Time;
@ManyToOne(cascade = CascadeType.ALL)
private Users u;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public LocalDate getOrder_Time() {
	return order_Time;
}
public void setOrder_Time(LocalDate order_Time) {
	this.order_Time = order_Time;
}
public LocalDate getDel_Time() {
	return del_Time;
}
public void setDel_Time(LocalDate del_Time) {
	this.del_Time = del_Time;
}
public Users getU() {
	return u;
}
public void setU(Users u) {
	this.u = u;
}

}
