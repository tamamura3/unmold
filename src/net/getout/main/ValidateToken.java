package net.getout.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

//tokenをDBと照合　登録があればtrueを返す

public class ValidateToken {
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public boolean excuteValidation(String token) {
		boolean tokenResult = false;

		try {
			//DBに接続してtokenと一致するデータを取得
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM register WHERE token = ? AND flag = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, token);
			ps.setInt(2, 0);
			ResultSet rs = ps.executeQuery();

			//データがあれば時間を取得する
			if (rs.next()) {
				Timestamp date = rs.getTimestamp("date"); //Timestamp型をDate型に代入
				date.setTime(date.getTime() + 86400 * 1000); //getした時間に24hをプラス
				Timestamp nowDate = new Timestamp(System.currentTimeMillis()); //get current time
				long longDate = date.getTime(); //convert to long to conpare
				long longNowDate = nowDate.getTime();

				//時間内だったらtrueを返す＆本登録を行う&registerのflagを1にする
				if (longNowDate < longDate) {
					String sqlRegister = "INSERT INTO user(name, mail, password)VALUES(?, ?, ?)";
					PreparedStatement pres = con.prepareStatement(sqlRegister);
					pres.setString(1, rs.getString("name"));
					pres.setString(2, rs.getString("mail"));
					pres.setString(3, rs.getString("password"));
					pres.executeUpdate();

					String sqlFlagChange = "UPDATE register SET flag = 1 WHERE token = ?";
					PreparedStatement pres2 = con.prepareStatement(sqlFlagChange);
					pres2.setString(1, token);
					pres2.executeUpdate();

					tokenResult = true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tokenResult;
	}
}
