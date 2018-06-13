package nl.hu.ict.dp.nscasus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ovchipkaart")
public class OVChipkaart_old {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "kaart_Sequeeence")
    @SequenceGenerator(name = "kaart_Sequeeence", sequenceName = "KAAReeT_SEQ")
    private int kaartnr;
    
    private Date geldigheid;
    private String kaartopdruk;

    public int getKaartnr() {
        return kaartnr;
    }

    public void setKaartnr(int kaartnr) {
        this.kaartnr = kaartnr;
    }

    public Date getGeldigheid() {
        return geldigheid;
    }

    public void setGeldigheid(Date geldigheid) {
        this.geldigheid = geldigheid;
    }

    public String getKaartopdruk() {
        return kaartopdruk;
    }

    public void setKaartopdruk(String kaartopdruk) {
        this.kaartopdruk = kaartopdruk;
    }

    public String toString() {
        return "OVChipkaart{" +
                "kaartnr=" + kaartnr +
                ", geldigheid=" + geldigheid +
                ", kaartopdruk='" + kaartopdruk + '\'' +
                '}';
    }
}
