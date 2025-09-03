
// ToDoタスク管理データベースへのアクセスを行う

//9/2の午後から行う。

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public boolean insertTask(String task_name, String task_contents, String task_limitdate,
            String task_user, int task_status) {
    	try {
    			Class.forName("org.postgresql.Driver");
    	} catch (ClassNotFoundException e) {
    	throw new IllegalStateException("JDBCドライバを読み込めませんでした", e);
    		}

    	String sql = "INSERT INTO taskinfo (task_name, task_contents, task_limitdate, task_update, task_user, task_status) " +
    			"VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?, ?)";

    	try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
    			PreparedStatement pStmt = conn.prepareStatement(sql)) {

    		pStmt.setString(1, task_name);
    		pStmt.setString(2, task_contents);
    		pStmt.setDate(3, java.sql.Date.valueOf(task_limitdate)); // "YYYY-MM-DD"形式
    		pStmt.setString(4, task_user);
    		
    		pStmt.setInt(5, task_status);

    		int result = pStmt.executeUpdate();
    		return result == 1;

    		} catch (SQLException e) {
    			e.printStackTrace();
    			return false;
    		}
    }
    
  

        public List<TaskInfo> getAllTasks() {
            List<TaskInfo> taskList = new ArrayList<>();

            String sql = "SELECT * FROM taskinfo ORDER BY task_id";

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                 PreparedStatement pStmt = conn.prepareStatement(sql);
                 ResultSet rs = pStmt.executeQuery()) {

                while (rs.next()) {
                    String task_id = String.valueOf(rs.getInt("task_id"));
                    String task_name = rs.getString("task_name");
                    String task_contents = rs.getString("task_contents");
                    String task_limitdate = rs.getString("task_limitdate");
                    String task_update = rs.getString("task_update");
                    String task_delete = rs.getString("task_delete");
                    String task_user = rs.getString("task_user");
                    String task_status = String.valueOf(rs.getInt("task_status"));

                    TaskInfo task = new TaskInfo(task_id, task_name, task_contents,
                            task_limitdate, task_update, task_delete,
                            task_user, task_status);
                    
                    // セッターがない場合はコンストラクタを拡張するか、フィールドを public にする必要があります
                    // ここでは TaskInfo に全フィールドを渡すコンストラクタを作るのがベストです

                    taskList.add(task);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return taskList;
        }
    }
    	


