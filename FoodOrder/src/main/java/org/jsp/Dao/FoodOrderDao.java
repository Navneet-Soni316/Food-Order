package org.jsp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Dto.FoodOrder;
import org.jsp.Dto.Users;

public class FoodOrderDao {
EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
public FoodOrder saveFoodOrder(FoodOrder f,int uid) {
	Users u=manager.find(Users.class, uid);
	if(u!=null) {
		u.getFoodOrder().add(f);
		f.setU(u);
		EntityTransaction t=manager.getTransaction();
		manager.persist(f);
		t.begin();
		t.commit();
		return f;
	}
	return null;
}
public FoodOrder updateFoodOrder(FoodOrder f,int uid) {
	Users u=manager.find(Users.class, uid);
	if(u!=null) {
		f.setU(u);
		EntityTransaction t=manager.getTransaction();
		manager.merge(f);
		t.begin();
		t.commit();
		return f;
	}
	return null;
}
public FoodOrder getFoodOrderByFID(int fid) {
	return manager.find(FoodOrder.class, fid);
	
}

public List<FoodOrder> getFoodOrderByUid(int UserId) {
	Users u=manager.find(Users.class, UserId);
	if(u!=null) {
		String qry="select f From FoodOrder f  where f.u.id=?1" ;
		Query q=manager.createQuery(qry);
		q.setParameter(1, UserId);
		return q.getResultList();
		
	}
	return null;
}
public List<FoodOrder> getFoodOrderByUserEmailANdPassword(String email, String password) {
	String qry= "select f from FoodOrder f where f.u.email=?1 and f.u.password=?2";
	Query q=manager.createQuery(qry);
	q.setParameter(1, email);
	q.setParameter(2, password);
	return q.getResultList();
}

public void deleteOrder(FoodOrder order,int fid)
{
  FoodOrder fo=manager.find(FoodOrder.class, fid);
  if(fo!=null)
  {
    EntityTransaction t=manager.getTransaction();
    manager.remove(order);
    t.begin();
    t.commit();
    
  }
}
}
