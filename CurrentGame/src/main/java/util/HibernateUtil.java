package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static final SessionFactory SF=buildSessionFactory();
    
    @SuppressWarnings("deprecation")
    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("SessionFactory oluşturulamadı."+ ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return SF;
    }
    
    public static void shutdown(){
        getSessionFactory().close();
    }
}
