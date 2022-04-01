package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDao {

	@SuppressWarnings("rawtypes")
	public ArrayList findAllVilles();

	@SuppressWarnings("rawtypes")
	public ArrayList findVille(String nomCodeInsee);

	public String createVille(Ville ville);

	public String modifyVille(Ville ville);

	public String deleteVille(String code);
}