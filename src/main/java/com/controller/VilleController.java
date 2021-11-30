package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VilleController {
	
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public String appelGet(@RequestParam(required=false, value="codePostal") String codePostal) {
		System.out.println("Appel Get");
		return "Hello";
	}
}
