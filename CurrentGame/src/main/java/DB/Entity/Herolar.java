package DB.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Herolar implements Serializable {
    
    @Id
    private int HId;
    private String HAdi;

    public Herolar() {
    }
 
    public Herolar(int HId, String HAdi) {
        this.HId = HId;
        this.HAdi = HAdi;
    }

    public int getHId() {
        return HId;
    }

    public void setHId(int HId) {
        this.HId = HId;
    }

    public String getHAdi() {
        return HAdi;
    }

    public void setHAdi(String HAdi) {
        this.HAdi = HAdi;
    }
    
    
}
