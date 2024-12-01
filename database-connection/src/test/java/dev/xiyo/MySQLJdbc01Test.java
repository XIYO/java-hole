package dev.xiyo;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class MySQLJdbc01Test {

    @Test
    public void jbcdTest() {
        // MySQL 접속 정보
        String jdbcUrl = "jdbc:mysql://localhost:3306/springbasic"; // your_database를 실제 DB 이름으로 변경
        String username = "root"; // MySQL 사용자 이름
        String password = "my-secret-pw"; // MySQL 비밀번호

        // 스트림의 클로즈는 try () 블록을 벗어나면 자동으로 호출됨
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("MySQL 연결 성공!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}