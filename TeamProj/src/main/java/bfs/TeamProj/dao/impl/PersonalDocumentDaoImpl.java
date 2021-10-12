package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.PersonalDocumentDao;
import bfs.TeamProj.domain.PersonalDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository("personalDocumentJdbcDao")
public class PersonalDocumentDaoImpl implements PersonalDocumentDao {
    private JdbcTemplate jdbcTemplate;
    private static final String GET_ALL_PERSONAL_DOCUMENT_BY_ID = "SELECT * FROM personalDocument where employeeId = ?";
    private static final String INSERT_PERSONAL_DOCUMENT = "INSERT INTO personalDocument (comment, createdBy, createdDate, path, title, employeeId) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public Integer addPersonalDocument(PersonalDocument doc, int employeeId) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_PERSONAL_DOCUMENT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, doc.getComment());
            statement.setString(2, doc.getCreatedBy());
            statement.setDate(3, Date.valueOf(doc.getCreatedDate()));
            statement.setString(4, doc.getPath());
            statement.setString(5, doc.getTitle());
            statement.setInt(6, employeeId);
            return statement;
        }, holder);
        return holder.getKey().intValue();
    }

    @Override
    public List<PersonalDocument> getPersonalDocumentListById(int id) {
        return jdbcTemplate.query(GET_ALL_PERSONAL_DOCUMENT_BY_ID, new BeanPropertyRowMapper<>(PersonalDocument.class), id);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
