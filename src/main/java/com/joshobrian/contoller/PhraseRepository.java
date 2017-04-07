package com.joshobrian.contoller;

import com.joshobrian.model.Phrase;

import java.sql.*;

/**
 * Created by josh on 4/6/17.
 */
public class PhraseRepository {
	//Remove
	private Connection conn;
	private PreparedStatement pre;
	private ResultSet rs;

	public PhraseRepository(String jdbc){
		try{
			conn = DriverManager.getConnection(jdbc);
		}catch (SQLException sql){

		}
	}

	public Phrase getPhasesByCategory(int id)throws Exception{
		pre = conn.prepareStatement("SELECT p.id AS id,p.phrase AS phrase, c.id AS cat_id, c.category_type AS category FROM phrases AS p\n" +
				"    JOIN categories AS c ON p.category_id = c.id\n" +
				"    WHERE category_id=?\n" +
				"ORDER BY RANDOM()\n" +
				"LIMIT 1;");
		pre.setInt(1,2);
		rs = pre.executeQuery();
		rs.next();

		return new Phrase(rs.getInt("id"),rs.getInt("cat_id"),
				rs.getString("category"),rs.getString("phrase"));
	}



}
