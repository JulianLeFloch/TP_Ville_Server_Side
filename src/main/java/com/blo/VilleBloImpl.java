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
		return villeDao.findAllVilles();
		
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getInfoVille(String nomCodeInsee) {
		return villeDao.findVille(nomCodeInsee);
	}
	
	public String postVille(Ville ville) {
		return villeDao.createVille(ville);
	}

	public String modifyVille(Ville ville) {
		return villeDao.modifyVille(ville);
	}

	public String deleteVille(String code) {
		return villeDao.deleteVille(code);
	}
}