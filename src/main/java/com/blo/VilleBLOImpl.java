package com.blo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.JDBCConfig;
import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;
	
	/**
	 * GET method to retrieve data from DB
	 * 
	 * @param Code_postal
	 */
	@SuppressWarnings("unused")
	@Override
	public ArrayList<Ville> getInfoVille(String Code_postal) {
		ArrayList<Ville> villes = new ArrayList<Ville>();

		// Opening connection
		try {
			Connection con = JDBCConfig.openConnection();
						
			if (Code_postal == null) {
				villes = villeDAO.getVille();
			} else {
				villes = villeDAO.getVilleByCodePostal(Code_postal);
			}
			System.out.println(
					"Nombre de villes : " + villes.size() + '\n');
			int i=0;
			while(i<villes.size()) {
				System.out.println(
						villes.get(i).getCode_commune_INSEE() + " "
						+ villes.get(i).getNom_commune() + " "
						+ villes.get(i).getCode_postal());
			}
			
			// closing connection
			con = JDBCConfig.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return villes;
	}

	/**
	 * POST method to add data into DB
	 * 
	 * @param ville
	 */
	@SuppressWarnings("unused")
	@Override
	public Ville postVille(Ville ville) {
		
		try {
			//opening connection
			Connection con = JDBCConfig.openConnection();
			
			villeDAO.addVille(ville);
			System.out.println(
					"Ajout d'une ville : \n" 
					+ ville.getCode_commune_INSEE() + " "
					+ ville.getNom_commune() + " "
					+ ville.getCode_postal());
			
			// closing connection
			con = JDBCConfig.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
						
		return ville;
	}
}