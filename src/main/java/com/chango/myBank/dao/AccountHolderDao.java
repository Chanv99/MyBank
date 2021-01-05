package com.chango.myBank.dao;

import java.util.List;

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
	public void createAccount(AccountHolder ah)
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(ah);
	}
	
	@Transactional
	public List<AccountHolder> getAccounts()
	{
		Session session = sessionFactory.getCurrentSession();
		List<AccountHolder> accountHolders = session.createQuery("from AccountHolder",AccountHolder.class).list();
		return accountHolders;
	}
	
	@Transactional
	public void updateAccount(AccountHolder ah)
	{
		Session session = sessionFactory.getCurrentSession();
		session.update(ah);
	}
	
	@Transactional
	public void deleteAccount(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete AccountHolder where id = :ID");
		query.setParameter("ID",id);
		query.executeUpdate();
	}
	
}
