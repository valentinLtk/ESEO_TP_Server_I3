package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeService;

	/**
	 * GET method to retrieve data
	 * 
	 * @param Code_postal
	 */
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "Code_postal") String Code_postal) {
		System.out.println("Appel GET");
		
		return villeService.getInfoVille(Code_postal);
	}
	
	/**
	 * POST method to add data
	 * 
	 * @param ville
	 */
	@RequestMapping(value = "/addVille", method = RequestMethod.POST)
	@ResponseBody
	public Ville appelPost(@RequestParam(required = false, value = "ville") Ville ville) {
		System.out.println("Appel POST");

		return villeService.postVille(ville);
	}
}