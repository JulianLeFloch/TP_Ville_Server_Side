package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface Ville_Dao {
	
	@SuppressWarnings("rawtypes")
	public ArrayList findAllVilles();

	@SuppressWarnings("rawtypes")
	public ArrayList findVille(String nom_Code_Insee);

	public String createVille(Ville ville);
	
	public String modifyVille(Ville ville);

	public String deleteVille(String code);

}