package com.simpleGame.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@Component
@RestController
@RequestMapping("api/users")
public class PostgresDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    void setJdb(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
        String sqlRecords = "CREATE TABLE IF NOT EXISTS records(id text not null,score int not null,primary key(id))";
        jdbcTemplate.execute(sqlRecords);
    }
    @GetMapping("/test")
    public ResponseEntity PostgresDAO() {
        String sql="select id from records";
        List<String> list=jdbcTemplate.query(sql,(rs,row)->rs.getString("id"));
        String ans="";
        for(int i=0;i<list.size();i++)
            ans+=list.get(i)+" ";
        return ResponseEntity.ok().body(ans);
    }
}
