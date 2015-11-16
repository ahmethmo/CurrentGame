package Ara.Jsons;

import Ara.Entity.HeroIstatistik;
import constant.Region;
import dto.League.League;
import dto.League.LeagueEntry;
import dto.Stats.ChampionStats;
import dto.Stats.PlayerStatsSummary;
import java.util.List;
import java.util.Locale;
import main.java.riotapi.RiotApi;

public class IstatistiklerJson {
    
    public HeroIstatistik IstatistikleriGetir(int KullaniciId,int HeroId, Region Rgn){ //Istatistikler
        HeroIstatistik HI=new HeroIstatistik();
        try {
            RiotApi a=new RiotApi("128e3596-795c-461c-8a9a-9ef6f6db8c14", Rgn);
            RiotApi b=new RiotApi("83605dd9-8857-4712-a993-91dfb2b3ba2c", Rgn);
            RiotApi c=new RiotApi("125324b8-fb02-4585-a219-30ba96c6bbbb", Rgn);
            
            List<PlayerStatsSummary> sumry= b.getPlayerStatsSummary(KullaniciId).getPlayerStatSummaries();
            for (PlayerStatsSummary sum : sumry) {
                if (sum.getPlayerStatSummaryType().equals("RankedSolo5x5")){
                    HI.setRankedWin(sum.getWins());
                    HI.setRankedLose(sum.getLosses());
                }
                if (sum.getPlayerStatSummaryType().equals("Unranked")){
                    HI.setUnRankedWin(sum.getWins());
                }
            }
             
            
            List<ChampionStats> camp= a.getRankedStats(KullaniciId).getChampions();
            double Kill=0,Dead=0,Asist=0,TopOynama=0;
            double KOrt=0,DOrt=0,AOrt=0; 
            for (ChampionStats campp : camp) {
                if (HeroId==campp.getId()){
                    TopOynama   =campp.getStats().getTotalSessionsPlayed();
                    if (TopOynama!=0){
                        Kill        =campp.getStats().getTotalDeathsPerSession();
                        Dead        =campp.getStats().getTotalChampionKills();
                        Asist       =campp.getStats().getTotalAssists();
                        KOrt=(Math.round((Kill/TopOynama)*100))/100.0;
                        DOrt=(Math.round((Dead/TopOynama)*100))/100.0;
                        AOrt=(Math.round((Asist/TopOynama)*100))/100.0;
                    }
                    HI.setOrtKill(KOrt);
                    HI.setOrtDead(DOrt);
                    HI.setOrtAsist(AOrt);
                    HI.setTopGalibiyet(campp.getStats().getTotalSessionsWon());
                    HI.setTopMalubiyet(campp.getStats().getTotalSessionsLost());
                    HI.setTopOyun(campp.getStats().getTotalSessionsPlayed());
                    break;
                } 
            }
            
            List<League>x= c.getLeagueBySummoner((long)KullaniciId);
            List<LeagueEntry>z;
            for (League x1 : x) {
                if (x1.getQueue().equals("RANKED_SOLO_5x5")) {
                    z=x1.getEntries();
                    for (LeagueEntry z1 : z) {
                        if (z1.getPlayerOrTeamId().equals(String.valueOf(KullaniciId))){
                            if (z1.getMiniSeries()==null){
                               HI.setSeriGalibiyet(z1.getWins());
                               HI.setSeriMalubiyet(z1.getWins());
                            }
                            HI.setLigi(x1.getTier().charAt(0)+x1.getTier().substring(1).toLowerCase(Locale.ENGLISH));
                            HI.setLigNumarası(z1.getDivision());
                            HI.setLigPaunı(z1.getLeaguePoints());
                        }
                    }
                    break;
                }
            }
        } catch (Exception e) {
        }
        return HI;
    }    
}
