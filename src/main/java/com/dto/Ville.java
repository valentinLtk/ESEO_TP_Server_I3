package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville {
	public String Code_commune_INSEE;
	public String Nom_commune;
	public String Code_postal;
	public String Libelle_acheminement;
	public String Ligne_5;
	public String Latitude;
	public String Longitude;
}


