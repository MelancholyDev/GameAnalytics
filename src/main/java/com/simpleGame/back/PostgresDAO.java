package com.simpleGame.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
@RestController
@RequestMapping("analytics")
public class PostgresDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    void setJdb(DataSource dataSource) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "Morrigan181");
        Statement statement = con.createStatement();
        String sql = "SELECT 'CREATE DATABASE analytics' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname='analytics')";
        statement.execute(sql);
        jdbcTemplate = new JdbcTemplate(dataSource);
        String sqlRecords = "CREATE TABLE IF NOT EXISTS deaths(id serial primary key,level text,x numeric,y numeric,z numeric)";
        String sqlRecords2 = "CREATE TABLE IF NOT EXISTS levels(id serial primary key,level_number integer,level_name text,event_type text)";
        String sqlRecords3 = "CREATE TABLE IF NOT EXISTS checkpoints(id serial primary key,level_name text,stage_number integer,event_type text)";
        String sqlRecords4 = "CREATE TABLE IF NOT EXISTS stages(id serial primary key,level_name text,stage_number integer,event_type text)";
        jdbcTemplate.execute(sqlRecords);
        jdbcTemplate.execute(sqlRecords2);
        jdbcTemplate.execute(sqlRecords3);
        jdbcTemplate.execute(sqlRecords4);
    }

    @PostMapping("/death")
    public ResponseEntity deathRecord(@RequestBody DeathRecord record) {
        System.out.println(record.getLevel() + " " + record.getX() + " " + record.getY() + " " + record.getZ());
        String sql = "insert into deaths(level,x,y,z) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, record.getLevel(), record.getX(), record.getY(), record.getZ());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/level")
    public ResponseEntity levelRecord(@RequestBody LevelRecord record) {
        System.out.println(record.getLevel_name() + " " + record.getLevel_Number() + " " + record.getEvent_type());
        String sql = "insert into levels(level_number,level_name,event_type) VALUES(?,?,?)";
        jdbcTemplate.update(sql, record.getLevel_Number(), record.getLevel_name(), record.getEvent_type());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/checkpoint")
    public ResponseEntity checkpointRecord(@RequestBody CheckpointRecord record) {
        System.out.println(record.getLevel_name() + " " + record.getStage_number() + " " + record.getEvent_type());
        String sql = "insert into checkpoints(level_name,stage_number,event_type) VALUES(?,?,?)";
        jdbcTemplate.update(sql, record.getLevel_name(), record.getStage_number(), record.getEvent_type());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/stage")
    public ResponseEntity stageRecord(@RequestBody StageRecord record) {
        System.out.println(record.getLevel_name() + " " + record.getStage_number() + " " + record.getEvent_type());
        String sql = "insert into stages(level_name,stage_number,event_type) VALUES(?,?,?)";
        jdbcTemplate.update(sql, record.getLevel_name(), record.getStage_number(), record.getEvent_type());
        return new ResponseEntity(HttpStatus.OK);
    }


}
