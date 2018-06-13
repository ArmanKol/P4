package nl.hu.ict.dp.nscasus;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "reiziger")
public class Reiziger {
	private String voorletter, tussenvoegsel, achternaam;
	private Date gbdatum;
	
	@SequenceGenerator(name = "reiziger_Sequence", sequenceName = "REIZIGER_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "reiziger_Sequence")
	@Id private int id;
	
	private ArrayList<OVChipkaart> listOVC = new ArrayList<OVChipkaart>();
	
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
	
	public ArrayList<OVChipkaart> getOVChipkaartList() {
		return listOVC;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Date getGBdatum() {
		return this.gbdatum;
	}
	
	public void setGBdatum(Date gbdm) {
		this.gbdatum = gbdm;
	}
	
	public void setVoorl(String voorl) {
		this.voorletter = voorl;
	}
	
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	
	public void setReizigerOVChipkaart(OVChipkaart kaart) {
		this.listOVC.add(kaart);
		
	}
	
	public String toString() {
		return "[ id: " + getId() + "] [naam: " + getNaam() + "] [geboortedatum: " + gbdatum + "]";
	}
}
