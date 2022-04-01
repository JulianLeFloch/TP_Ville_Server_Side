package com.dto;

public class Ville {
	String codeCommuneInsee;
	String nomCommune;
	String codePostal;
	String libelleAcheminement;
	String ligne5;
	String latitude;
	String longitude;
	public String getCodeCommuneInsee() {
		return codeCommuneInsee;
	}
	public void setCodeCommuneInsee(String codeCommune) {
		codeCommuneInsee = codeCommune;
	}
	public String getNomCommune() {
		return nomCommune;
	}
	public void setNomCommune(String nom) {
		nomCommune = nom;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostalCommune) {
		codePostal = codePostalCommune;
	}
	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}
	public void setLibelleAcheminement(String acheminement) {
		libelleAcheminement = acheminement;
	}
	public String getLigne5() {
		return ligne5;
	}
	public void setLigne5(String ligne) {
		ligne5 = ligne;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitudeCommune) {
		latitude = latitudeCommune;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitudeCommune) {
		longitude = longitudeCommune;
	}
	
}
