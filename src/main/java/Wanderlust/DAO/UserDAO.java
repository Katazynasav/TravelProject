package Wanderlust.DAO;

import Wanderlust.Domain.User;
import Wanderlust.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class UserDAO {
    public static void createUser(User user) {
        Transaction transaction = null;
        try {
            transaction = null;

            Session session = HibernateUtils.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }


    public User getUser(String Email) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.bySimpleNaturalId(User.class).load(Email);
        session.close();
        return user;
    }


    public String identifyUser(String Email) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("select userEmail from User where userEmail = :parameterEmail");
            query.setParameter("parameterEmail", Email);
            List list = query.list();
            String email = String.valueOf(list);
            session.close();
            return email;


        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }


    public void deleteUser(User user) {
        Transaction transaction = null;
        try {
            transaction = null;
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(user);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updateUser(User user) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}











