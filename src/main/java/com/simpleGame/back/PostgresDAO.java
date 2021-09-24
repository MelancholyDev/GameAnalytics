package com.simpleGame.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Component
@RestController
@RequestMapping("analytics")
public class PostgresDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    void setJdb(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
        String sqlRecords = "CREATE TABLE IF NOT EXISTS deaths(id serial primary key,level text,x numeric,y numeric,z numeric)";
        jdbcTemplate.execute(sqlRecords);
    }
    @PostMapping("/death")
    public ResponseEntity PostgresDAO(DeathRecord record) {
        System.out.println(record.getLevel()+" "+record.getX()+" "+record.getY()+" "+record.getZ());
        String sql="insert into deaths(level,x,y,z) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,record.getLevel(),record.getX(),record.getY(),record.getZ());
        return new ResponseEntity(HttpStatus.OK);
    }

}
