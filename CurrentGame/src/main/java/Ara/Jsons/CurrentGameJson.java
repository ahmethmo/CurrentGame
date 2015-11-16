package Ara.Jsons;

import Ara.Entity.BanlıHero;
import Ara.Entity.CurrentGame;
import Ara.Entity.HeroIstatistik;
import Ara.Entity.Sihirdarlar;
import DB.Comp.BuyulerComp;
import DB.Comp.HerolarComp;
import DB.Comp.RunlerComp;
import DB.Entity.Runler;
import constant.PlatformId;
import constant.Region;
import dto.CurrentGame.BannedChampion;
import dto.CurrentGame.CurrentGameInfo;
import dto.CurrentGame.Mastery;
import dto.CurrentGame.Participant;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import main.java.riotapi.RiotApi;
import main.java.riotapi.RiotApiException;

public class CurrentGameJson {
    
    public CurrentGame GetCurrentgame(String Isim,String Rgn){ //Region Rgn
        try {
            //DÖNDÜRÜLECEK SONUÇLAR //////////////////////////////////////////////////////
            CurrentGame CG=new CurrentGame();
            List<Sihirdarlar> shrdrlar=new ArrayList<>();
            List<BanlıHero> bnlhrlar=new ArrayList<>();
            //DÖNDÜRÜLECEK SONUÇLAR //////////////////////////////////////////////////////
            
            //VERİ TABANINDAN BİLGİLERİ GETİR///////////////////////////////////////////////
            Map<Integer,String> HeroIsimleri=   new HerolarComp().HerolarıGetir();
            Map<Integer,String> BuyuIsımleri=   new BuyulerComp().BuyuleriGetir();
            Map<Integer,Runler> RunIsimleri=    new RunlerComp().RunleriGetir();
            //VERİ TABANINDAN BİLGİLERİ GETİR///////////////////////////////////////////////
            
            //OYUN BİLGİLERİNİ ÇEKME////////////////////////////////////////////////////////
            Region Rgion =BölgeGetir(Rgn);
            RiotApi Ana=new RiotApi("c47b8398-b0a3-419c-84df-b3073820da13", Rgion);
            long SId=Ana.getSummonerByName(Isim).getId();
            CurrentGameInfo CGI=Ana.getCurrentGameInfo(PlatformGetir(Rgn), SId);
            //OYUN BİLGİLERİNİ ÇEKME////////////////////////////////////////////////////////
            
            //BANLI HEROLAR/////////////////////////////////////////////////////////////////
            List<BannedChampion> bnc= CGI.getBannedChampions();
            for (BannedChampion temp : bnc) {
                BanlıHero bnhr=new BanlıHero();
                bnhr.setHero(HeroIsimleri.get((int)temp.getChampionId()));
                bnhr.setPickTurn(temp.getPickTurn());
                bnhr.setTakımNo((int) temp.getTeamId());
                bnlhrlar.add(bnhr);
            }
            //BANLI HEROLAR/////////////////////////////////////////////////////////////////
                
            //SİHİRDARLAR///////////////////////////////////////////////////////////////////
            List<Participant> prt= CGI.getParticipants();
            for (Participant temp : prt) {
                Sihirdarlar shrdr=new Sihirdarlar();
                String KblytSonuc=GetKabiliyetler(temp.getMasteries());
                List<String> RunSonuc=GetRunler(temp.getRunes(),RunIsimleri);
                HeroIstatistik KDA=new IstatistiklerJson().IstatistikleriGetir((int)temp.getSummonerId(),(int) temp.getChampionId(),Rgion);
                
                shrdr.setSummonerName(temp.getSummonerName());
                shrdr.setHero((String) HeroIsimleri.get((int)temp.getChampionId()));
                shrdr.setSpell1(BuyuIsımleri.get((int)temp.getSpell1Id()));
                shrdr.setSpell2(BuyuIsımleri.get((int)temp.getSpell2Id()));
                shrdr.setMasteries(KblytSonuc);
                shrdr.setRunes(RunSonuc);
                shrdr.setHeroStatistics(KDA);
                shrdr.setTakımNo((int) temp.getTeamId());
                
                shrdrlar.add(shrdr);
		//System.out.println("Sihirdar Adı.....:"+temp.getSummonerName());
                //System.out.println("Şampiyon Adı.....:"+HeroIsimleri.get((int)temp.getChampionId())+" ("+KDA.getTopGalibiyet()+" + "+KDA.getTopMalubiyet()+" = "+KDA.getTopOyun()+")");
                //System.out.println("Ligi.............:"+KDA.getLigi()+" "+KDA.getLigNumarası()+" ("+KDA.getLigPaunı()+")");
                //System.out.println("Normal Galibiyet.:"+KDA.getUnRankedWin());
                //System.out.println("Dereceli G/M.....:"+KDA.getRankedWin()+" / "+KDA.getRankedLose());
                //System.out.println("KDA..............:"+KDA.getOrtKill()+" / "+KDA.getOrtDead()+" / "+KDA.getOrtAsist());
                //System.out.println("Takım Numarası...:"+temp.getTeamId());
                //System.out.println("Sihirdar Büyüleri:"+BuyuIsımleri.get((int)temp.getSpell1Id())+" + "+BuyuIsımleri.get((int)temp.getSpell2Id()));
                //System.out.println("Kabiliyetler.....:"+KblytSonuc);
                /*System.out.println("Runler...........:");
                for (String RunSonuc1 : RunSonuc) {
                    System.out.println("   "+RunSonuc1);
                }
                System.out.println("---------------------------------------------------------------");*/
            }
            //SİHİRDARLAR///////////////////////////////////////////////////////////////////
            
            CG.setBnlhrlar(bnlhrlar);
            CG.setShrdrlar(shrdrlar);
            return CG;
        } catch (RiotApiException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    private Region BölgeGetir(String rgn){
        Region region=null;
        switch (rgn) {
            case "BR":
                region=Region.BR;
                break;
            case "EUNE":
                region=Region.EUNE;
                break;
            case "EUW":
                region=Region.EUW;
                break;
            case "KR":
                region=Region.KR;
                break;
            case "LAN":
                region=Region.LAN;
                break;
            case "LAS":
                region=Region.LAS;
                break;
            case "NA":
                region=Region.NA;
                break;
            case "OCE":
                region=Region.OCE;
                break;
            case "RU":
                region=Region.RU;
                break;
            case "TR":
                region=Region.TR;
                break;
        }
        return region;
    }
    
     private PlatformId PlatformGetir(String rgn){
        PlatformId PltId=null;
        switch (rgn) {
            case "BR":
                PltId=PlatformId.BR;
                break;
            case "EUNE":
                PltId=PlatformId.EUNE;
                break;
            case "EUW":
                PltId=PlatformId.EUW;
                break;
            case "KR":
                PltId=PlatformId.KR;
                break;
            case "LAN":
                PltId=PlatformId.LAN;
                break;
            case "LAS":
                PltId=PlatformId.LAS;
                break;
            case "NA":
                PltId=PlatformId.NA;
                break;
            case "OCE":
                PltId=PlatformId.OCE;
                break;
            case "RU":
                PltId=PlatformId.RU;
                break;
            case "TR":
                PltId=PlatformId.TR;
                break;
        }
        return PltId;
    }
        
    private String GetKabiliyetler(List<Mastery> Kblytler){ //KabiliyetleriHesapla
        int Sg=0,Yg=0,Is=0;
        for (Mastery Kb : Kblytler) {
            if (((int)Kb.getMasteryId())<4200)
                Sg=Sg+Kb.getRank();
            else if (((int)Kb.getMasteryId())<4300)
                Yg=Yg+Kb.getRank();
            else 
                Is=Is+Kb.getRank();
        }
        return (Sg+"/"+Yg+"/"+Is);
    } 
    
    private List<String> GetRunler(List<dto.CurrentGame.Rune> Runs , Map<Integer,Runler> RunIsımleri){ //RunleriHesapla
        List<String> a=new ArrayList<>();
        double sayi1=0.0,sayi2=0.0;
        String SonucRun;
        
        for (dto.CurrentGame.Rune runss : Runs) {
            Runler run=RunIsımleri.get((int)runss.getRuneId());

            if (run.getSayi2()<0) {
                sayi1=run.getSayi1()*runss.getCount();
                SonucRun=run.getTamMetin().replace("AAA",String.valueOf(new DecimalFormat("###.###").format(sayi1)));
                a.add(SonucRun);
            }else{
                sayi1=run.getSayi1()*runss.getCount();
                sayi2=run.getSayi2()*runss.getCount();
                SonucRun=run.getTamMetin().replace("AAA",String.valueOf(new DecimalFormat("###.###").format(sayi1)));
                SonucRun=SonucRun.replace("BBB",String.valueOf(new DecimalFormat("###.###").format(sayi2)));
                a.add(SonucRun);
            }
        }
        return a;
    }
}
