package dev.xiyo.tomcatmavenspring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class HelloDao {

    private final JdbcTemplate jdbcTemplate;

    public HelloDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String sayHello() {
        // SQL 쿼리 실행
        String sql = "SELECT 'hello' AS greeting";
        return jdbcTemplate.queryForObject(sql, String.class);
    }
}