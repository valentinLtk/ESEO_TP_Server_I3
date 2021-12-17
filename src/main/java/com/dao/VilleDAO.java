package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {

	/**
	 * Returning all 'Ville' corresponding to the parameter
	 * 
	 * @param Code_postal
	 */
	public ArrayList<Ville> getVilleByCodePostal(String Code_postal);
	
	/**
	 * Returning all 'Ville' method
	 */
	public ArrayList<Ville> getVille();

	/**
	 * Adding a 'Ville' 
	 * 
	 * @param ville
	 */
	void addVille(Ville ville);

}
