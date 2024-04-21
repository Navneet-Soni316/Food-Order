package org.jsp.controller;

import java.time.LocalDate;
import java.util.Scanner;

import org.jsp.Dao.FoodOrderDao;
import org.jsp.Dao.UserDao;
import org.jsp.Dto.FoodOrder;
import org.jsp.Dto.Users;

public class UserController {
static Scanner sc=new Scanner(System.in);
static FoodOrderDao fddao=new FoodOrderDao();
static UserDao udao=new UserDao();
public static void main(String[] args) {
	System.out.println("1. save the user");	
	System.out.println("2. update the user");	
	System.out.println("3. save the foodOrder");	
	System.out.println("4. update the foodOrder");		
	System.out.println("7. delete foodOrder");	
	System.out.println("enter your choice");
	int choice=sc.nextInt();
switch (choice) {
case 1:saveUser();
break;
case 2:updateUser();
	break;
case 3:
	saveFoodOrder();
	break;
case 4:updateFoodOrder();
break;
case 5:deleteFoodItem();
break;
default:
	break;
}
	}
public static void saveUser() {
	System.out.println("enter the user name, email,paswword,phone,gender");
	String name=sc.next();
	String email=sc.next();
	String pwd=sc.next();
	long phone=sc.nextLong();
	String gender=sc.next();
	Users u=new Users();
	u.setEmail(email);
	u.setName(name);
	u.setPhone(phone);
	u.setPassword(pwd);
	u.setGender(gender);
	udao.saveUser(u);
}
public static void updateUser() {
	System.out.println("enter the uid ");
	int uid=sc.nextInt();
	Users u= udao.getUserById(uid);
	if(u!=null)
	
	System.out.println("enter the user name, email,paswword,phone,gender");
	String name=sc.next();
	String email=sc.next();
	String pwd=sc.next();
	long phone=sc.nextLong();
	String gender=sc.next();
	u.setEmail(email);
	u.setName(name);
	u.setPhone(phone);
	u.setPassword(pwd);
	u.setGender(gender);
	udao.updateUser(u);
	System.out.println("record upadted with id"+u.getId());
}
public static void saveFoodOrder() {
	System.out.println("enter the uid ");
	int uid=sc.nextInt();
	Users u= udao.getUserById(uid);
	if(u!=null) {
		System.out.println("enter the name,address,price ");
		String name=sc.next();
		String address=sc.next();
		double price=sc.nextDouble();
		FoodOrder f=new FoodOrder();
		f.setAddress(address);
		f.setItemName(name);
		f.setPrice(price);
		f.setOrder_Time(LocalDate.parse("3003-12-03"));
		f.setDel_Time(LocalDate.parse("3003-12-04"));
		fddao.saveFoodOrder(f, uid);
		System.out.println("the order savesd with id "+f.getId());
		
	}
	
}
public static void updateFoodOrder() {
	FoodOrder f=new FoodOrder();
	System.out.println("enter the uid ");
	int uid=sc.nextInt();
	Users u= udao.getUserById(uid);
	if(u!=null) {
		System.out.println("enter the foodOrder id");
		int fid=sc.nextInt();
		f=fddao.getFoodOrderByFID(fid);
		if(f!=null) {
			System.out.println("engter the name,address,ordertime,delivery,price ");
			String name=sc.next();
			String address=sc.next();
			double price=sc.nextDouble();
			
			f.setAddress(address);
			f.setItemName(name);
			f.setPrice(price);
			f.setOrder_Time(LocalDate.parse("3003-12-03"));
			f.setDel_Time(LocalDate.parse("3003-12-04"));
			fddao.updateFoodOrder(f, uid);
			System.out.println("the order savesd with id "+f.getId());
		}
		
		
	}
}
public static void deleteFoodItem() {
	System.out.println("enter foodItem id");
	System.out.println("Enter Order_Id To Delete");
    int fid=sc.nextInt();
    FoodOrder fo=fddao.getFoodOrderByFID(fid);
    if(fo!=null)
    {
      fddao.deleteOrder(fo, fid);
    }
    else
    {
      System.err.println("Invalid Order_Id !!!!! ");
    }
    
	
	
}
}
