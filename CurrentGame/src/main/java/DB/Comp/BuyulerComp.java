package DB.Comp;

import DB.Entity.Buyuler;
import dto.Static.SummonerSpell;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.riotapi.RiotApi;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class BuyulerComp {
    
    public boolean BuyuleriEkle(RiotApi Ana){ //SihirdarBuyuleriniVeritabanınaEkle
        try {
            Session ses=HibernateUtil.getSessionFactory().openSession();
            ses.beginTransaction();
            Map<String,SummonerSpell> z=Ana.getDataSummonerSpellList().getData();
            for (String key : z.keySet()) {
                SummonerSpell buyu=z.get(key);
                Buyuler buyuler= new Buyuler(buyu.getId(), buyu.getName());
                ses.persist(buyuler);
            }
            ses.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Buyuler Eklenmedi."+ e.getMessage());
            return false;
        }
    }
    
    public Map BuyuleriGetir(){  //SihirdarBuyuleriniCek
        try{
            Session ses=HibernateUtil.getSessionFactory().openSession();
            ses.beginTransaction();
            Query query = ses.createQuery("from Buyuler");
            List<Buyuler> mapbuyu=query.list();    
            Map BuyuIsimleri=new HashMap();
            for (Buyuler temp : mapbuyu) {
                BuyuIsimleri.put(temp.getBId(), temp.getBAdi());
            }
            return BuyuIsimleri;
        }catch(Exception e){
            System.out.println("Buyuler Getirilemedi."+ e.getMessage());
            return null;
        }
    }
}
