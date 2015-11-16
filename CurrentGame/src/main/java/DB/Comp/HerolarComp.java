package DB.Comp;

import DB.Entity.Herolar;
import dto.Static.Champion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.riotapi.RiotApi;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class HerolarComp {
    
    public boolean HerolarıEkle(RiotApi Ana){ //HerolarıVeritabanınaEkle
        try {
            Session ses=HibernateUtil.getSessionFactory().openSession();
            ses.beginTransaction();
            Map<String,Champion> z=Ana.getDataChampionList().getData();
            for (String key : z.keySet()) {
                Champion hero=z.get(key);
                Herolar hrs= new Herolar(hero.getId(), hero.getName());
                ses.persist(hrs);
            }
            ses.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Herolar eklenemedi"+ e.getMessage());
            return false;
        }
    }
    
    public Map HerolarıGetir(){ //HerolarıCek
        try {
            Session ses=HibernateUtil.getSessionFactory().openSession();
            ses.beginTransaction();
            Query query = ses.createQuery("from Herolar");
            List<Herolar> maphero=query.list();    
            Map HeroISimleri=new HashMap();
            for (Herolar temp : maphero) {
                HeroISimleri.put(temp.getHId(), temp.getHAdi());
            }
            return HeroISimleri;
        } catch (Exception e) {
            System.out.println("Herolar Getirilemedi."+ e.getMessage());
            return null;
        }
    }  
}
