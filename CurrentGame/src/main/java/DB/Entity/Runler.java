package DB.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Runler implements Serializable {
    @Id
    private int RId;
    private String TamMetin;
    private double Sayi1;
    private double Sayi2;

    public Runler() {
    }

    public Runler(int RId, String TamMetin, double Sayi1, double Sayi2) {
        this.RId = RId;
        this.TamMetin = TamMetin;
        this.Sayi1 = Sayi1;
        this.Sayi2 = Sayi2;
    }

    public Runler(String TamMetin, double Sayi1, double Sayi2) {
        this.TamMetin = TamMetin;
        this.Sayi1 = Sayi1;
        this.Sayi2 = Sayi2;
    }

    public int getRId() {
        return RId;
    }

    public void setRId(int RId) {
        this.RId = RId;
    }
 
    public String getTamMetin() {
        return TamMetin;
    }

    public void setTamMetin(String TamMetin) {
        this.TamMetin = TamMetin;
    }

    public double getSayi1() {
        return Sayi1;
    }

    public void setSayi1(double Sayi1) {
        this.Sayi1 = Sayi1;
    }

    public double getSayi2() {
        return Sayi2;
    }

    public void setSayi2(double Sayi2) {
        this.Sayi2 = Sayi2;
    }

    
}
