
// ToDoタスク管理データベースへのアクセスを行う

//9/2の午後から行う。

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoTaskDAO {

    private final String JDBC_URL = "jdbc:postgresql://localhost:5432/todotask";
    private final String DB_USER = "postgres";
    private final String DB_PASS = "sql";

    // ログイン情報を確認するメソッド（例）
    public boolean isLoginValid(String user_id, String user_pass) {
        try {
            // JDBCドライバのロード
            Class.forName("org.postgresql.Driver");
            System.out.println("データベースと接続成功");
        } catch (ClassNotFoundException e) {
        	System.out.println("データベースと接続失敗");
            throw new IllegalStateException("JDBCドライバを読み込めませんでした", e);
            
        }

        // データベース接続とクエリ実行(別のログインサーブレットに書く内容かも)
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT USER_ID, USER_PASS FROM LOGIN WHERE USER_ID = ? AND USER_PASS = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, user_id);
            pStmt.setString(2, user_pass);

            ResultSet rs = pStmt.executeQuery();
            
            System.out.println(rs);
            
            return rs.next(); // 一致するユーザーがいれば true を返す

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
