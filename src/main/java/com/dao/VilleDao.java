package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDao {

	@SuppressWarnings("rawtypes")
	public ArrayList TrouverVilles();

	@SuppressWarnings("rawtypes")
	public ArrayList TrouverVille(String codeCommuneInsee);

	public String CreerVille(Ville ville);

	public String ModifierVille(Ville ville);

	public String SupprimerVille(String codeCommuneInsee);
}