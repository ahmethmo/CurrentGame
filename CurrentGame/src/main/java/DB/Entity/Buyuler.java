package DB.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Buyuler implements Serializable {
    @Id
    private int BId;
    private String BAdi;

    public Buyuler() {
    }

    public Buyuler(int BId, String BAdi) {
        this.BId = BId;
        this.BAdi = BAdi;
    }

    public int getBId() {
        return BId;
    }

    public void setBId(int BId) {
        this.BId = BId;
    }

    public String getBAdi() {
        return BAdi;
    }

    public void setBAdi(String BAdi) {
        this.BAdi = BAdi;
    }
    
    
    
}
