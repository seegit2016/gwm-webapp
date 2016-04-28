package com.zhanyun.gwm.dao;


import org.springframework.security.crypto.password.PasswordEncoder;



/**
 * Initialize the database with some test entries.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 */
public class DataBaseInitializer
{

/*	private NewsEntryDao newsEntryDao;

	private UserDao userDao;
*/
	private PasswordEncoder passwordEncoder;


	protected DataBaseInitializer()
	{
		/* Default constructor for reflection instantiation */
	}


/*	public DataBaseInitializer(UserDao userDao, NewsEntryDao newsEntryDao, PasswordEncoder passwordEncoder)
	{
		this.userDao = userDao;
		this.newsEntryDao = newsEntryDao;
		this.passwordEncoder = passwordEncoder;
	}*/


	public void initDataBase()
	{

	}

}