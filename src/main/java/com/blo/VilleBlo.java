package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBlo {

	@SuppressWarnings("rawtypes")
	public ArrayList getInfoVilles();

	@SuppressWarnings("rawtypes")
	public ArrayList getInfoVille(String nomCodeInsee);

	public String postVille(Ville ville);

	public String modifyVille(Ville ville);

	public String deleteVille(String code);
}
