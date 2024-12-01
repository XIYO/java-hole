package dev.xiyo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLJdbc01 {
    public static void main(String[] args) {
        // MySQL 접속 정보
        String jdbcUrl = "jdbc:mysql://localhost:3306/springbasic"; // your_database를 실제 DB 이름으로 변경
        String username = "root"; // MySQL 사용자 이름
        String password = "my-secret-pw"; // MySQL 비밀번호

        // 스트림의 클로즈는 try () 블록을 벗어나면 자동으로 호출됨
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("MySQL 연결 성공!");

            // SQL 실행 예제
            String sql = "SELECT * FROM user_info"; // your_table을 실제 테이블 이름으로 변경
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String pwd = rs.getString("pwd");
                String social = rs.getString("sns");

                System.out.println(id + ", " + name + ", " + email + ", " + pwd + ", " + social);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
