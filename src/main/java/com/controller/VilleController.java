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
		System.out.println("Lancement de l'appel GET : Avoir toutes les villes");

		return villeBloService.getInfoVilles();
	}
	
	// Méthode GET
		@SuppressWarnings("rawtypes")
		@CrossOrigin
		@RequestMapping(value = "/Ville", method = RequestMethod.GET)
		@ResponseBody
		public ArrayList ville(@RequestParam(value = "code_commune_INSEE") String nomCodeInsee) {
			System.out.println("Lancement de l'appel GET : Avoir une seule ville par code insee");

			return villeBloService.getInfoVille(nomCodeInsee);
		}
		
		// Méthode POST
		@CrossOrigin
		@RequestMapping(value = "/Ville_Ajouter", method = RequestMethod.POST)
		@ResponseBody
		public String createVille(@RequestBody Ville ville) {
			System.out.println("Lancement de la méthode POST : Ajouter une ville --> "  + ville.getNomCommune());

			String reponse = villeBloService.postVille(ville);
			return reponse;
		}
		
		//Méthode PUT
		@CrossOrigin
		@RequestMapping(value = "/Ville_Modifier", method = RequestMethod.PUT)
		@ResponseBody
		public String modifyVille(@RequestBody Ville ville) {
			System.out.println("Lancement de la méthode PUT : Modification d'une ville " + ville.getNomCommune());

			String reponse = villeBloService.modifyVille(ville);
			return reponse;
		}
		
		// Méthode DELETE
		@CrossOrigin
		@RequestMapping(value = "/Ville_Enlever", method = RequestMethod.DELETE)
		@ResponseBody
		public String deleteVille(@RequestParam(value = "code_commune_INSEE") String code) {
			System.out.println("Lancement de la méthode DELETE : Suppression d'une ville");
			
			String reponse = villeBloService.deleteVille(code);
			return reponse;
		}
}