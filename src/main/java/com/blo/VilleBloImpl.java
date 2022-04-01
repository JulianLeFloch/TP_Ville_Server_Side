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
	public ArrayList getInfoVilles() {
		ArrayList villes;

		villes = villeDao.findAllVilles();
		return villes;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList getInfoVille(String nomCodeInsee) {
		ArrayList ville;

		ville = villeDao.findVille(nomCodeInsee);
		return ville;
	}

	public String postVille(Ville ville) {
		String reponse = villeDao.createVille(ville);
		return reponse;
	}

	public String modifyVille(Ville ville) {
		String reponse = villeDao.modifyVille(ville);
		return reponse;
	}

	public String deleteVille(String code) {
		String reponse = villeDao.deleteVille(code);
		return reponse;
	}
}