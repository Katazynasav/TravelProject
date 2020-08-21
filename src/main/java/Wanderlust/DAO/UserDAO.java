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

    public String getUser(String email) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Query query = session.createQuery("Select userPassword FROM User WHERE userEmail = :parameterEmail");
            query.setParameter("parameterEmail", email);
            List list = query.list();
            String password = String.valueOf(list);
            session.close();
            return password;


        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }
}