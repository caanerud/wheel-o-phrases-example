package com.joshobrian.contoller;

import com.joshobrian.model.GameResults;
import com.joshobrian.model.Phrase;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Created by josh on 4/6/17.
 */
public class GameRepository {

	//Remove
	private Connection conn;
	private PreparedStatement pre;
	private ResultSet rs;

	public GameRepository(String jdbc){
		try{
			conn = DriverManager.getConnection(jdbc);
		}catch (SQLException sql){

		}
	}
	//Todo make more secure might need to adjust table
	public int startGame(Phrase phrase) throws SQLException {
		pre = conn.prepareStatement("INSERT INTO game(category_id, datetime) VALUES (\n" +
				"?,now()\n" +
				");");
		pre.setInt(1,phrase.getCategoryId());
		pre.execute();
		return getGameID();
	}

	public int getGameID() throws SQLException {
		pre = conn.prepareStatement("SELECT id FROM game ORDER BY datetime desc LIMIT 1");
		rs = pre.executeQuery();
		rs.next();
		return rs.getInt("id");
	}
	//TODO Hookup
	public void insertGameResults(GameResults results) throws SQLException {
		pre = conn.prepareStatement("INSERT INTO game_results(game_id, player_id, phrase_id, iswinner)VALUES (?,?,?,?);");
		pre.setInt(1,results.getGameID());
		pre.setInt(2,results.getPlayerID());
		pre.setInt(3, results.getPhaseID());
		pre.setBoolean(4,results.isWinner());
		pre.execute();

	}
}
