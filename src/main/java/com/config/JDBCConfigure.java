package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;

public class JDBCConfigure {

	static ResourceBundle info = ResourceBundle.getBundle("application");
	
	@Bean
	public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(System.getenv().get("db_name"), System.getenv().get("db_user"), System.getenv().get("db_pwd"));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur sur la connection !");
            System.exit(0);
            return null;
        }
	}
}
