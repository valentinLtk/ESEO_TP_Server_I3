package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfig;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO{
	

	/**
	 * Returning all 'Ville' corresponding to 
	 * the parameter 'Code_postal' entered
	 * 
	 * @param param
	 */
	@Override
	public ArrayList<Ville> findVilleWithCodePostal(String Code_postal) {
		
		// Connection parameters
		Statement stm;
		ResultSet rs;
		
		ArrayList<Ville> villes = new ArrayList<Ville>();
		
		// Opening connection
		try {
			Connection con = JDBCConfig.openConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(
					"SELECT * FROM ville_france WHERE Code_postal =" + Code_postal + ";");
			
			while(rs.next()) {
				Ville ville = new Ville();
			
				ville.setCode_commune_INSEE(rs.getString("Code_commune_INSEE"));
				ville.setNom_commune(rs.getString("Nom_commune"));
				ville.setCode_postal(rs.getString("Code_postal"));
								
				villes.add(ville);
			}
			
			// closing connection
			con = JDBCConfig.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return villes;
	}

	/**
	 * Returning all 'Ville' method
	 *
	 */
	@Override
	public ArrayList<Ville> findVille() {
		// Connection parameters
		Statement stm;
		ResultSet rs;
		
		ArrayList<Ville> villes = new ArrayList<Ville>();
		
		// Opening connection
		try {
			Connection con = JDBCConfig.openConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(
					"SELECT * FROM ville_france;");
			
			while (rs.next()) {
				Ville ville = new Ville();
				ville.setNom_commune(rs.getString("Nom_Commune"));

				villes.add(ville);
			}
			
			// closing connection
			con = JDBCConfig.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return villes;
	}
	
	/**
	 * Adding a 'Ville' 
	 * 
	 * @param ville
	 */
	@Override
	public void addVille(Ville ville) {
		// Connection parameters
		Statement stm;
		
		//Opening connection
		try {
			Connection con = JDBCConfig.openConnection();
			stm = con.createStatement();
			stm.executeQuery(
					"INSERT INTO ville_france VALUES(" 
					+ ville.getCode_commune_INSEE() + ","
					+ ville.getNom_commune() + ","
					+ ville.getCode_postal() + ","
					+ ville.getLibelle_acheminement() + ","
					+ ville.getLigne_5() + ","
					+ ville.getLatitude() + ","
					+ ville.getLongitude() + ");");
			
			// closing connection
			con = JDBCConfig.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
