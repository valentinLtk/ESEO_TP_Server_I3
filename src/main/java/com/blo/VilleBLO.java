package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	/**
	 * GET method to display 'Ville' elements
	 * 
	 * @param param
	 */
	public ArrayList<Ville> getInfoVille(String Code_postal);

	/**
	 * POST method
	 * 
	 * @param ville
	 */
	public Ville postVille(Ville ville);

}
