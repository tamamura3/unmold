package net.getout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

//tokenの有無をreset_passテーブルで確認。OKなら時間をチェック。全てOKならtrueを返す

public class VerifyTokenTimeDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public boolean verifyTokenAndTime(String token) {
		boolean result = false;

		try {
			//DBに接続してtokenと一致するデータを取得
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM reset_pass WHERE token = ? AND flag = 0";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, token);
			ResultSet rs = ps.executeQuery();

			//データがあれば時間を取得する
			if (rs.next()) {
				Timestamp date = rs.getTimestamp("date"); //Timestamp型をDate型に代入
				date.setTime(date.getTime() + 86400 * 1000); //getした時間に24hをプラス
				Timestamp nowDate = new Timestamp(System.currentTimeMillis()); //get current time
				long longDate = date.getTime(); //convert to long to conpare
				long longNowDate = nowDate.getTime();

				//時間内だったらtrueを返す
				if (longNowDate < longDate) {
					result = true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;


	}

}
