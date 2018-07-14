package com.jm.tracker.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jm.tracker.obj.TaskObj;
import com.jm.tracker.util.HibernateUtil;

public class HibernateOneToManyMain {

	public static void main(String[] args) {
		
		TaskObj taskObj = new TaskObj();
		taskObj.setTaskDesc("A test data");
		taskObj.setTaskName("Sample data");
		taskObj.setUserId("TEST_USER");
		
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try{
			//Get Session
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			System.out.println("Session created");
			//start transaction
			tx = session.beginTransaction();
			
			//Save the Model objects
			session.save(taskObj);
//			session.save(item1);
//			session.save(item2);
			
			//Commit transaction
			tx.commit();
			System.out.println("Cart ID="+taskObj.getTaskId());
			
			}catch(Exception e){
				System.out.println("Exception occured. "+e.getMessage());
				e.printStackTrace();
			}finally{
				if(!sessionFactory.isClosed()){
					System.out.println("Closing SessionFactory");
					sessionFactory.close();
				}
			}
		
	}

}
