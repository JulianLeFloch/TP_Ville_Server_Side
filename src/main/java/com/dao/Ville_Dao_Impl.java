package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBC_Configure;
import com.dto.Ville;

@Repository
public class Ville_Dao_Impl implements Ville_Dao {
	
	@SuppressWarnings("rawtypes")
	public ArrayList findAllVilles() {
		Ville ville = null;
		Statement st = null;
		ResultSet rs = null;
		Connection conn = null;
		@SuppressWarnings("unchecked")
		ArrayList<Ville> villes = new ArrayList();
		try {
			conn = JDBC_Configure.getConnection();
			String query = "SELECT * FROM ville_france";

			st = conn.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				ville = new Ville();
				ville.setCode_commune_INSEE(rs.getString("Code_commune_INSEE"));
				ville.setNom_commune(rs.getString("Nom_Commune"));
				ville.setCode_postal(rs.getString("Code_postal"));
				ville.setLibelle_acheminement(rs.getString("Libelle_acheminement"));
				ville.setLigne_5(rs.getString("Ligne_5"));
				ville.setLatitude(rs.getString("Latitude"));
				ville.setLongitude(rs.getString("Longitude"));
				villes.add(ville);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return villes;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList findVille(String nom_Code_Insee) {
		Ville ville = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		@SuppressWarnings({ "unchecked" })
		ArrayList<Ville> villeDemandee = new ArrayList();
		try {
			conn = JDBC_Configure.getConnection();
			String query = "SELECT * FROM ville_france WHERE code_commune_INSEE="+nom_Code_Insee;
			st = conn.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				ville = new Ville();
				ville.setCode_commune_INSEE(rs.getString("Code_commune_INSEE"));
				ville.setNom_commune(rs.getString("Nom_Commune"));
				ville.setCode_postal(rs.getString("Code_postal"));
				ville.setLibelle_acheminement(rs.getString("Libelle_acheminement"));
				ville.setLigne_5(rs.getString("Ligne_5"));
				ville.setLatitude(rs.getString("Latitude"));
				ville.setLongitude(rs.getString("Longitude"));
				villeDemandee.add(ville);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return villeDemandee;
	}

	public String createVille(Ville ville) {
		Connection conn = null;
		String reponse = "echec";
		Statement st = null;
		try {
			conn = JDBC_Configure.getConnection();
			String query = "INSERT INTO ville_france VALUES('" + ville.getCode_commune_INSEE() + "', '"
					+ ville.getNom_commune() + "', '" + ville.getCode_postal() + "', '"
					+ ville.getLibelle_acheminement() + "', '" + ville.getLigne_5() + "', '" + ville.getLatitude()
					+ "', '" + ville.getLongitude() + "')";
			st = conn.createStatement();
			System.out.println(query);
			st.executeUpdate(query);
			reponse = "reussite";
			return reponse;
		} catch (SQLException e) {
			e.printStackTrace();
			return reponse;
		}
	}

	public String modifyVille(Ville ville) {
		Connection conn = null;
		String reponse = "echec";
		Statement st = null;
		
		try {
			conn = JDBC_Configure.getConnection();
			String query = "UPDATE ville_france SET Nom_commune='" + ville.getNom_commune() + "', Code_postal='"
					+ ville.getCode_postal() + "', Libelle_acheminement='" + ville.getLibelle_acheminement()
					+ "', Ligne_5='" + ville.getLigne_5() + "', Latitude='" + ville.getLatitude() + "', Longitude='"
					+ ville.getLongitude() + "' WHERE Code_commune_INSEE='" + ville.getCode_commune_INSEE() + "'";
			st = conn.createStatement();
			System.out.println(query);
			st.executeUpdate(query);
			reponse = "reussite";
			return reponse;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return reponse;
		}
	}

	public String deleteVille(String code) {
		Connection conn = null;
		String reponse = "echec";
		Statement st = null;
		
			try {
				conn = JDBC_Configure.getConnection();
				String query = "DELETE FROM ville_france WHERE Code_commune_INSEE=" + code;
				st = conn.createStatement(); 
				st.executeUpdate(query);
				reponse = "reussite";
				return reponse;
			}
			
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return reponse;
		}
	}
}

