package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBlo;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBlo villeBloService;

	// Méthode GET

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/Villes", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList Villes() {
		return villeBloService.AvoirToutesLesVilles();
	}

	// Méthode GET
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/Ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList Ville(@RequestParam(value = "codeCommuneInsee") String code) {
		return villeBloService.AvoirUneVille(code);
	}

	// Méthode POST
	@CrossOrigin
	@RequestMapping(value = "/Ville_Ajouter", method = RequestMethod.POST)
	@ResponseBody
	public String CreerVille(@RequestBody Ville villeAjoutee) {
		return villeBloService.AjouterUneVille(villeAjoutee);
	}

	// Méthode PUT
	@CrossOrigin
	@RequestMapping(value = "/Ville_Modifier", method = RequestMethod.PUT)
	@ResponseBody
	public String ModifierVille(@RequestBody Ville villeModifiee) {
		return villeBloService.ModifierUneVille(villeModifiee);
	}

	// Méthode DELETE
	@CrossOrigin
	@RequestMapping(value = "/Ville_Enlever", method = RequestMethod.DELETE)
	@ResponseBody
	public String SupprimerVille(@RequestParam(value = "codeCommuneInsee") String codeSuppr) {
		return villeBloService.SupprimerUneVille(codeSuppr);
	}
}