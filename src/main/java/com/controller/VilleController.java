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
	public ArrayList villes() {
		return villeBloService.getInfoVilles();
	}

	// Méthode GET
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/Ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList ville(@RequestParam(value = "code_commune_INSEE") String nomCodeInsee) {
		return villeBloService.getInfoVille(nomCodeInsee);
	}

	// Méthode POST
	@CrossOrigin
	@RequestMapping(value = "/Ville_Ajouter", method = RequestMethod.POST)
	@ResponseBody
	public String createVille(@RequestBody Ville ville) {
		return villeBloService.postVille(ville);
	}

	// Méthode PUT
	@CrossOrigin
	@RequestMapping(value = "/Ville_Modifier", method = RequestMethod.PUT)
	@ResponseBody
	public String modifyVille(@RequestBody Ville ville) {
		return villeBloService.modifyVille(ville);
	}

	// Méthode DELETE
	@CrossOrigin
	@RequestMapping(value = "/Ville_Enlever", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteVille(@RequestParam(value = "code_commune_INSEE") String code) {
		return villeBloService.deleteVille(code);
	}
}