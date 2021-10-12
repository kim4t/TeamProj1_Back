package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.RegistrationTokenDao;
import bfs.TeamProj.domain.RegistrationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Repository("registrationTokenJdbcDao")
public class RegistrationTokenDaoImpl implements RegistrationTokenDao {
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_TOKEN = "SELECT * FROM registrationToken";
    private static final String INSERT_TOKEN = "INSERT INTO registrationToken (createdBy, email, token, validDuration) " +
            "VALUES (?, ?, ?, ?)";

    @Override
    public Integer addRegistrationToken(RegistrationToken token) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_TOKEN, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, token.getCreatedBy());
            statement.setString(2, token.getEmail());
            statement.setString(3, token.getToken());
            statement.setTimestamp(4, Timestamp.valueOf(token.getValidDuration()));
            return statement;
        }, holder);
        return holder.getKey().intValue();
    }

    @Override
    public List<RegistrationToken> getAllRegistrationToken() {
        return jdbcTemplate.query(GET_ALL_TOKEN, new BeanPropertyRowMapper<>(RegistrationToken.class));
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
