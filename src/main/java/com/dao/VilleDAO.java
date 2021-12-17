package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {


	/**
	 * Returning all 'Ville' corresponding to the parameter
	 * 
	 * @param param
	 */
	public ArrayList<Ville> findVilleWithCodePostal(String Code_postal);
	
	/**
	 * Returning all 'Ville' method
	 */
	public ArrayList<Ville> findVille();

	/**
	 * Adding a 'Ville' 
	 * 
	 * @param ville
	 */
	void addVille(Ville ville);

}
