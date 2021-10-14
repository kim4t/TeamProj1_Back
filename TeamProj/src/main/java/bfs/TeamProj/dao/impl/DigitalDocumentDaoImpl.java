/*package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.DigitalDocumentDao;
import bfs.TeamProj.domain.DigitalDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository("digitalDocumentJdbcDao")
public class DigitalDocumentDaoImpl implements DigitalDocumentDao {
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_DIGITAL_DOC = "SELECT * FROM digitalDocument";
    private static final String INSERT_DIGITAL_DOC = "INSERT INTO digitalDocument (Required, description, templateLocation, type) " +
            "VALUES (?, ?, ?, ?)";

    @Override
    public Integer addDigitalDocument(DigitalDocument doc) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_DIGITAL_DOC, Statement.RETURN_GENERATED_KEYS);
            statement.setBoolean(1, doc.getRequired());
            statement.setString(2, doc.getDescription());
            statement.setString(3, doc.getTemplateLocation());
            statement.setString(4, doc.getType());
            return statement;
        }, holder);
        return holder.getKey().intValue();
    }

    @Override
    public List<DigitalDocument> getAllDigitalDocument() {
        return jdbcTemplate.query(GET_ALL_DIGITAL_DOC, new BeanPropertyRowMapper<>(DigitalDocument.class));
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}


 */