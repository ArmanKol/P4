package nl.hu.ict.dp.nscasus;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reiziger")
public class Reiziger {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "reiziger_Sequence")
    @SequenceGenerator(name = "reiziger_Sequence", sequenceName = "REIZIGER_SEQ")
    private int id;
    private String voorletter, tussenvoegsel, achternaam;
	private Date gbdatum;
	
	@OneToMany(targetEntity=OVChipkaart.class, mappedBy="OVChipkaartreiziger", cascade = CascadeType.ALL)
	private List<OVChipkaart>  reizigerOVChipkaart = new ArrayList<OVChipkaart>();
	
	public Reiziger(int id, String voorletter, String achternaam) {
		this.id = id;
		this.voorletter = voorletter;
		this.achternaam = achternaam;
	}
	
	public Reiziger() {
		
	}
	
	public void setVoorl(String voorl) {
		voorletter = voorl;
	}
	
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	
	public void setGBdatum(Date geboortedatum) {
		this.gbdatum = geboortedatum;
	}

    public void setId(int id) {
    	this.id = id;
    }
	
    public String getVoorletter() {
		return this.voorletter;
	}
	
	public String getTussenvoegsel() {
		String ltussenvoegsel = "";
		if(this.tussenvoegsel == null) {
			ltussenvoegsel += "";
		}else {
			ltussenvoegsel += this.tussenvoegsel;
		}
		return ltussenvoegsel;
	}
	
	public String getAchternaam() {
		return this.achternaam;
	}
	
	public String getNaam() {
		String volledigeNaam = "";
		if(tussenvoegsel == null || tussenvoegsel == "") {
			volledigeNaam += this.voorletter + " " + this.achternaam;
		}else{
			volledigeNaam += this.voorletter + " " + this.tussenvoegsel + " " + this.achternaam;
		}
		
		return volledigeNaam;
	}
	
	public Date getGBdatum() {
		return gbdatum;
	}
	
	public int getID() {
		return id;
	}
	
	public void addOVChipkaart(OVChipkaart ovc) {
		this.reizigerOVChipkaart.add(ovc);
		ovc.setReiziger(this);
	}
	
	public String toString() {
		return "Reiziger{naam= " + getNaam() + " Geboortedatum= " + gbdatum + " ID= " + id + "}";
	}
}
