package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBlo {

	@SuppressWarnings("rawtypes")
	public ArrayList AvoirToutesLesVilles();

	@SuppressWarnings("rawtypes")
	public ArrayList AvoirUneVille(String codeCommuneInsee);

	public String AjouterUneVille(Ville ville);

	public String ModifierUneVille(Ville ville);

	public String SupprimerUneVille(String codeCommuneInsee);
}
