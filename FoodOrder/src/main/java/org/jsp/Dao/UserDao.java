package org.jsp.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Dto.Users;

public class UserDao {
EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
public Users saveUser(Users a) {
	EntityTransaction t=manager.getTransaction();
	manager.persist(a);
	t.begin();
	t.commit();
	return a;
	
}

public Users updateUser(Users user) {
	EntityTransaction t=manager.getTransaction();
	manager.merge(user);
	t.begin();
	t.commit();
	return user;
	
}

public Users getUserById(int uid) {
	return manager.find(Users.class, uid);
	
}
public Users getUsersByEmailANdPassword(String email,String pwd) {
	String qry="select u from Users u where u.email=?1 and u.password=?2";
	Query q=manager.createQuery(qry);
	q.setParameter(1, email);
	q.setParameter(2, pwd);
	return (Users) q.getSingleResult();
}

}
