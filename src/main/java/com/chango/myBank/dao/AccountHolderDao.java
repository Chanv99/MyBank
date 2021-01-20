package com.chango.myBank.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chango.myBank.models.AccountHolder;

@Component
public class AccountHolderDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Transactional
	public void createAccount(AccountHolder ah) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ah);
	}

	@Transactional
	public List<AccountHolder> getAccounts() {
		Session session = sessionFactory.getCurrentSession();
//		List<AccountHolder> accountHolders = session.createQuery("from AccountHolder", AccountHolder.class).list();
//		return accountHolders;
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery <AccountHolder> cr = cb.createQuery(AccountHolder.class);
		Root<AccountHolder> root = cr.from(AccountHolder.class);
		cr.select(root);
		Query<AccountHolder> query = session.createQuery(cr);
		List<AccountHolder> results = query.getResultList();
		return results;
	}

	@Transactional
	public void updateAccount(AccountHolder ah) {
		Session session = sessionFactory.getCurrentSession();
		session.update(ah);
	}

	@Transactional
	public void deleteAccount(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete AccountHolder where id = :ID");
		query.setParameter("ID", id);
		query.executeUpdate();
	}

	@Transactional
	public AccountHolder getAccountHolder(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		AccountHolder accountHolder = session.get(AccountHolder.class, id);
		return accountHolder;
	}
	
	@Transactional
	public List<AccountHolder> search(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		List<AccountHolder> accountHolders = session.createQuery("from AccountHolder as A where A.name like % :c %").setParameter("c", keyword).list();
		
		return accountHolders;
	}
	
}

// Query query = session.createQuery("insert into AccountHolder (accountBalance
// , address , contactNo , name) values (:a,:b,:c,:d)");
// query.setParameter("a",ah.getAccountBalance());
// query.setParameter("b",ah.getAddress());
// query.setParameter("c",ah.getContactNo());
// query.setParameter("d",ah.getName());
// query.executeUpdate();
