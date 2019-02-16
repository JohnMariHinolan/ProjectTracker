package com.jm.tracker.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.tracker.obj.RemarksObj;
import com.jm.tracker.obj.Tags;
import com.jm.tracker.obj.TaskInfo;
import com.jm.tracker.obj.TaskObj;
import com.jm.tracker.util.HibernateUtil;

public class HibernateOneToManyMain {

	public static void main(String[] args) {
		testHibernate();
		// testJckson();
		// saveTags();
		// oneToOne();

	}

	private static void testJckson() {

		ObjectMapper objectMapper = new ObjectMapper();
		TaskObj taskObj = new TaskObj();
		taskObj.setTaskDesc("A test data NiV 26");
		taskObj.setTaskName("Sample data NiV 26");
		taskObj.setUserId("OCT 14");
		String jacksonTest = "";
		try {
			jacksonTest = objectMapper.writeValueAsString(taskObj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("jacksonTest: " + jacksonTest);

	}

	private static void testHibernate() {

		// TESTING ONLY
		TaskObj taskObj = new TaskObj();
		taskObj.setTaskId(4);
		taskObj.setTaskDesc("A test data NiV 26");
		taskObj.setTaskName("Sample data NiV 26");
		taskObj.setUserId("OCT 14");

		RemarksObj remarks = new RemarksObj();
		RemarksObj remarks2 = new RemarksObj();

		remarks.setRemark("Test Remark NOV 17");

		taskObj.addRemark(remarks);

		remarks2.setRemark("Test Remark2 NOV 17");
		;
		taskObj.addRemark(remarks2);

		TaskObj taskObjChild = new TaskObj();
		taskObjChild.setTaskDesc("A simpletest for child task");

		taskObjChild.setParentTaskObj(taskObj);
		taskObjChild.setUserId("UserCH");

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		try {
			// Get Session
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			System.out.println("Session created");
			// start transaction
			tx = session.beginTransaction();

			// Save the Model objects
			session.save(taskObj);
			session.save(taskObjChild);
			// session.save(item1);
			// session.save(item2);

			// Commit transaction
			tx.commit();
			System.out.println("Cart ID=" + taskObj.getTaskId());

		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}

	}

	private static void oneToOne() {

		// TESTING ONLY
		TaskObj taskObj = new TaskObj();
		taskObj.setTaskDesc("A test data Jan 9");
		taskObj.setTaskName("Sample data Jan 9");
		taskObj.setUserId("Jan 13");

		TaskInfo taskInfo = new TaskInfo();

		// taskInfo.setTaskInfoId(1);
		taskInfo.setDislikes(7);
		taskInfo.setLikes(4);

		Tags tag1 = new Tags();
		tag1.setProductId(12);
		// tag1.setTagId(1);
		tag1.setTaskDescription("SALAD");
		Tags tag2 = new Tags();
		tag2.setProductId(12);
		// tag2.setTagId(4);
		tag2.setTaskDescription("MEAT");

		List<Tags> listTags = new ArrayList<Tags>();
		listTags.add(tag1);
		listTags.add(tag2);

		taskInfo.setTags(listTags);

		taskObj.setTaskInfo(taskInfo);
		taskInfo.setTaskObj(taskObj);

		save(taskObj);

	}

	private static void saveEntityManager(Object object) {

		EntityManager entityManager = HibernateUtil.getEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(object);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	private static void saveTags() {
		TaskInfo taskInfo = new TaskInfo();

		taskInfo.setTaskInfoId(16);
		taskInfo.setDislikes(7);

		Tags tag1 = new Tags();
		tag1.setProductId(12);
		tag1.setTagId(1);
		tag1.setTaskDescription("SALAD");
		Tags tag2 = new Tags();
		tag2.setProductId(12);
		tag2.setTagId(4);
		tag2.setTaskDescription("MEAT");

		List<Tags> listTags = new ArrayList<Tags>();
		listTags.add(tag1);
		listTags.add(tag2);

		taskInfo.setTags(listTags);

		save(taskInfo);
	}

	private static void save(Object obj) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		try {
			// Get Session
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			System.out.println("Session created");
			// start transaction
			tx = session.beginTransaction();

			// Save the Model objects
			session.save(obj);

			// session.save(item1);
			// session.save(item2);

			// Commit transaction
			tx.commit();

		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}

	}

}
