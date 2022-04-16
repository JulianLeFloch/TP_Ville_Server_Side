package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.config.JDBCConfigure;
import com.dto.Ville;

@Repository
public class VilleDaoImpl implements VilleDao {
	Statement st = null;
	ResultSet rs = null;
	Connection conn = null;
	String reponse = "echec";
	Ville ville = null;
	String error = "Erreur lors de la requête";

	public ArrayList<Ville> TrouverVilles() {
		ArrayList<Ville> villes = new ArrayList<>();
		try {
			conn = JDBCConfigure.getConnection();
			String query = "SELECT * FROM ville_france";

			st = conn.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommuneInsee(rs.getString("Code_commune_INSEE"));
				ville.setNomCommune(rs.getString("Nom_Commune"));
				ville.setCodePostal(rs.getString("Code_postal"));
				ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
				ville.setLigne5(rs.getString("Ligne_5"));
				ville.setLatitude(rs.getString("Latitude"));
				ville.setLongitude(rs.getString("Longitude"));
				villes.add(ville);
			}

		} catch (SQLException e) {
			throw new Error(error);
		}

		return villes;
	}

	public ArrayList<Ville> TrouverVille(String nomCode) {

		ArrayList<Ville> villeDemandee = new ArrayList<>();
		try {
			conn = JDBCConfigure.getConnection();
			String query = "SELECT * FROM ville_france WHERE code_commune_INSEE=" + nomCode;
			st = conn.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommuneInsee(rs.getString("Code_commune_INSEE"));
				ville.setNomCommune(rs.getString("Nom_Commune"));
				ville.setCodePostal(rs.getString("Code_postal"));
				ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
				ville.setLigne5(rs.getString("Ligne_5"));
				ville.setLatitude(rs.getString("Latitude"));
				ville.setLongitude(rs.getString("Longitude"));
				villeDemandee.add(ville);
			}

		} catch (SQLException e) {
			throw new Error(error);
		}

		return villeDemandee;
	}

	public String CreerVille(Ville ville) {
		try {
			conn = JDBCConfigure.getConnection();
			
			String query = "INSERT INTO ville_france VALUES('"+ville.getCodeCommuneInsee()+"','"
					+ville.getNomCommune()+"','"+ville.getCodePostal()+"','"+ville.getLibelleAcheminement()
					+ "','"+ville.getLigne5()+"','"+ ville.getLatitude()+"','"+ville.getLongitude()+"')";
			st = conn.createStatement();
			System.out.println(query);
			st.executeUpdate(query);
			reponse = "reussite";
			return reponse;
		} catch (SQLException e) {
			throw new Error(error);
		}
	}

	public String ModifierVille(Ville ville) {
		try {
			conn = JDBCConfigure.getConnection();
			String query = "UPDATE ville_france SET Nom_commune='" + ville.getNomCommune() + "', Code_postal='"
					+ ville.getCodePostal() + "', Libelle_acheminement='" + ville.getLibelleAcheminement()
					+ "', Ligne_5='" + ville.getLigne5() + "', Latitude='" + ville.getLatitude() + "', Longitude='"
					+ ville.getLongitude() + "' WHERE Code_commune_INSEE='" + ville.getCodeCommuneInsee() + "'";
			st = conn.createStatement();
			System.out.println(query);
			st.executeUpdate(query);
			reponse = "reussite";
			return reponse;
		} catch (SQLException e) {
			throw new Error(error);
		}
	}

	public String SupprimerVille(String nomCode) {
		try {
			conn = JDBCConfigure.getConnection();
			String query = "DELETE FROM ville_france WHERE Code_commune_INSEE="+nomCode;
			st = conn.createStatement();
			st.executeUpdate(query);
			reponse = "reussite";
			return reponse;
		} catch (SQLException e) {
			throw new Error(error);
		}
	}
}
