package com.ex.app.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Asemat implements Serializable {

	public Asemat() {

	}

	public Asemat(Long fid, Long id, String name, String namn, String nimi, String osoite, String adres,
			String kaupunki, String stad, String operator, int kapasiteet, double x, double y) {
		this.fid = fid;
		this.id = id;
		this.name = name;
		this.namn = namn;
		this.nimi = nimi;
		this.osoite = osoite;
		this.adres = adres;
		this.kaupunki = kaupunki;
		this.stad = stad;
		this.Operator = operator;
		this.kapasiteet = kapasiteet;
		this.x = x;
		this.y = y;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public String getKaupunki() {
		return kaupunki;
	}

	public void setKaupunki(String kaupunki) {
		this.kaupunki = kaupunki;
	}

	public String getStad() {
		return stad;
	}

	public void setStad(String stad) {
		this.stad = stad;
	}

	public String getOperator() {
		return Operator;
	}

	public void setOperator(String operator) {
		Operator = operator;
	}

	public int getKapasiteet() {
		return kapasiteet;
	}

	public void setKapasiteet(int kapasiteet) {
		this.kapasiteet = kapasiteet;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Long getAsemaId() {
		return id;
	}

	public void setAsemaId(Long asemaId) {
		this.id = asemaId;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	private @Id @GeneratedValue Long fid;
	private @GeneratedValue Long id;
	private String name;
	private String namn;
	private String nimi;
	private String osoite;
	private String adres;
	private String kaupunki;
	private String stad;
	private String Operator;
	private int kapasiteet;
	private double x;
	private double y;

}
