package DB.Comp;

import DB.Entity.Runler;
import dto.Static.Rune;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.riotapi.RiotApi;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class RunlerComp {
    
    public boolean RunleriEkle(RiotApi Ana){ //RunleriVeritabanınaEkle
        try {
            Session ses=HibernateUtil.getSessionFactory().openSession();
            ses.beginTransaction();
            Map<String,Rune> z=Ana.getDataRuneList().getData();
            
            for (String key : z.keySet()) {
                Runler runn=RunParcala((z.get(key).getDescription()));
                runn.setRId(z.get(key).getId());
                ses.persist(runn);
            }
            ses.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Runler eklenemedi"+ e.getMessage());
            return false;
        }
    }
    
    private Runler RunParcala(String TamMetin){
        String SonChar=" ";
        int Konu11=1,Konu12=-1,Konu21=-1,Konu22=-1;
        String IlkSayi="-1",IkiSayi="-1";
        double IlkSayi1=-1,IkiSayi2=-1;
       
        String IlkChar=String.valueOf(TamMetin.charAt(0));
        if (TamMetin.indexOf("%")!=-1)
            SonChar="%";
        Konu12=TamMetin.indexOf(SonChar);
        Konu21=TamMetin.indexOf(IlkChar,Konu12);
        IlkSayi=TamMetin.substring(Konu11,Konu12);
        TamMetin=TamMetin.replaceAll(IlkSayi, "AAA");
        if (Konu21!=-1) {
            Konu22=TamMetin.indexOf(SonChar,Konu21);
            IkiSayi=TamMetin.substring(Konu21,Konu22);
            TamMetin=TamMetin.replace(IkiSayi, "BBB");
        }
        IlkSayi1=Double.parseDouble(IlkSayi);
        IkiSayi2=Double.parseDouble(IkiSayi);

        return (new Runler(TamMetin,IlkSayi1,IkiSayi2));
    } 
    
    public  Map<Integer,Runler> RunleriGetir(){ //RunleriCek
        try {
            Session ses=HibernateUtil.getSessionFactory().openSession();
            ses.beginTransaction();
            Query query = ses.createQuery("from Runler");
            List<Runler> runler=query.list(); 
            Map<Integer,Runler> Runss=new HashMap();
            for (Runler temp : runler) {
                Runss.put(temp.getRId(), temp);
            }
            return Runss;
        } catch (Exception e) {
            System.out.println("Runler Getirilemedi."+ e.getMessage());
            return null;
        }
    }
}
