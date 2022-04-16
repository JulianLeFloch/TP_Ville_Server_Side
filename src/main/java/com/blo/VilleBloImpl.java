package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDao;
import com.dto.Ville;

@Service
public class VilleBloImpl implements VilleBlo {

	@Autowired
	private VilleDao villeDao;
	
	@SuppressWarnings("rawtypes")
	public ArrayList AvoirToutesLesVilles() {
		return villeDao.TrouverVilles();	
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList AvoirUneVille(String nomCodeInsee) {
		return villeDao.TrouverVille(nomCodeInsee);
	}
	
	public String AjouterUneVille(Ville villeAjoutee) {
		return villeDao.CreerVille(villeAjoutee);
	}

	public String ModifierUneVille(Ville villeModifiee) {
		return villeDao.ModifierVille(villeModifiee);
	}

	public String SupprimerUneVille(String codeSuppression) {
		return villeDao.SupprimerVille(codeSuppression);
	}
}