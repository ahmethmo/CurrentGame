package Ara.Entity;

import java.util.List;

public class CurrentGame {
    private List<Sihirdarlar> shrdrlar;
    private List<BanlıHero> bnlhrlar;

    public CurrentGame() {
    }

    public CurrentGame(List<Sihirdarlar> shrdrlar, List<BanlıHero> bnlhrlar) {
        this.shrdrlar = shrdrlar;
        this.bnlhrlar = bnlhrlar;
    }

    public List<Sihirdarlar> getShrdrlar() {
        return shrdrlar;
    }

    public void setShrdrlar(List<Sihirdarlar> shrdrlar) {
        this.shrdrlar = shrdrlar;
    }

    public List<BanlıHero> getBnlhrlar() {
        return bnlhrlar;
    }

    public void setBnlhrlar(List<BanlıHero> bnlhrlar) {
        this.bnlhrlar = bnlhrlar;
    }
    
    
}
