package nl.hu.ict.dp.nscasus;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ovchipkaart")
public class OVChipkaart {
	
	@SequenceGenerator(name = "kaart_Sequence", sequenceName = "KAART_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "kaart_Sequence")
	@Id private int kaartnummer;
	
	private int klasse;
	private Reiziger reiziger;
	private double saldo;
	private Date geldigtot;
	private String kaartopdruk;
	
	public int getKaartnummer() {
		return this.kaartnummer;
	}
	
	public int getKlasse() {
		return this.klasse;
	}
	
	public Reiziger getReiziger() {
		return this.reiziger;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public Date getDate() {
		return this.geldigtot;
	}
	
	public String getKaartopdruk() {
		return kaartopdruk;
	}
	
	public void setKaartopdruk(String kaartopdruk) {
        this.kaartopdruk = kaartopdruk;
	}
	
	public String toString() {
		String x = "";		
		x += "[Kaartnummer: " + this.kaartnummer + "] - [Geldig tot: " + this.geldigtot + "] - [Klasse: " + this.klasse + "] - [Saldo: " + 
		this.saldo + "] - [" + reiziger + "]";

		return x;
	}
}
