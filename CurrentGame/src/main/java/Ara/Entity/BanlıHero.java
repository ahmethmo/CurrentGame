package Ara.Entity;

public class BanlıHero {
    private int PickTurn;
    private int TakımNo;
    private String Hero;

    public BanlıHero() {
    }

    public BanlıHero(int PickTurn, int TakımNo, String Hero) {
        this.PickTurn = PickTurn;
        this.TakımNo = TakımNo;
        this.Hero = Hero;
    }

    public int getPickTurn() {
        return PickTurn;
    }

    public void setPickTurn(int PickTurn) {
        this.PickTurn = PickTurn;
    }

    public int getTakımNo() {
        return TakımNo;
    }

    public void setTakımNo(int TakımNo) {
        this.TakımNo = TakımNo;
    }

    public String getHero() {
        return Hero;
    }

    public void setHero(String Hero) {
        this.Hero = Hero;
    }
    
    
}
