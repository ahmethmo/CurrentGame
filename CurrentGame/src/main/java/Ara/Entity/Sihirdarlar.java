package Ara.Entity;


import java.util.List;

public class Sihirdarlar {
    private String SummonerName;
    private String Spell1;
    private String Spell2;
    private String Hero;
    private String Masteries;
    private HeroIstatistik HeroStatistics;
    private List<String> Runes;
    private int TakımNo;

    public Sihirdarlar() {
    }

    public Sihirdarlar(String SummonerName, String Spell1, String Spell2, String Hero, String Masteries, HeroIstatistik HeroStatistics, List<String> Runes, int TakımNo) {
        this.SummonerName = SummonerName;
        this.Spell1 = Spell1;
        this.Spell2 = Spell2;
        this.Hero = Hero;
        this.Masteries = Masteries;
        this.HeroStatistics = HeroStatistics;
        this.Runes = Runes;
        this.TakımNo = TakımNo;
    }

    public int getTakımNo() {
        return TakımNo;
    }

    public void setTakımNo(int TakımNo) {
        this.TakımNo = TakımNo;
    }

    
    
    public String getSummonerName() {
        return SummonerName;
    }

    public void setSummonerName(String SummonerName) {
        this.SummonerName = SummonerName;
    }

    public String getSpell1() {
        return Spell1;
    }

    public void setSpell1(String Spell1) {
        this.Spell1 = Spell1;
    }

    public String getSpell2() {
        return Spell2;
    }

    public void setSpell2(String Spell2) {
        this.Spell2 = Spell2;
    }

    public String getHero() {
        return Hero;
    }

    public void setHero(String Hero) {
        this.Hero = Hero;
    }

    public String getMasteries() {
        return Masteries;
    }

    public void setMasteries(String Masteries) {
        this.Masteries = Masteries;
    }

    public HeroIstatistik getHeroStatistics() {
        return HeroStatistics;
    }

    public void setHeroStatistics(HeroIstatistik HeroStatistics) {
        this.HeroStatistics = HeroStatistics;
    }

    public List<String> getRunes() {
        return Runes;
    }

    public void setRunes(List<String> Runes) {
        this.Runes = Runes;
    }
    
    
}
