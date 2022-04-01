package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Ville_Dao;
import com.dto.Ville;

@Service
public class Ville_Blo_Impl implements Ville_Blo {

	@Autowired
	private Ville_Dao ville_Dao;
	
	@SuppressWarnings("rawtypes")
	public ArrayList getInfoVilles() {
		ArrayList villes;
		
		villes = ville_Dao.findAllVilles();
		return villes;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getInfoVille(String nom_Code_Insee) {
		ArrayList ville;
		
		ville = ville_Dao.findVille(nom_Code_Insee);
		return ville;
	}
	
	public String postVille(Ville ville) {
		String reponse = ville_Dao.createVille(ville);
		return reponse;
	}

	public String modifyVille(Ville ville) {
		String reponse = ville_Dao.modifyVille(ville);
		return reponse;
	}

	public String deleteVille(String code) {
		String reponse = ville_Dao.deleteVille(code);
		return reponse;
	}
}