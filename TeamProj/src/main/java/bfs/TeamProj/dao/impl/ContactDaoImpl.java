package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.ContactDao;
import bfs.TeamProj.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository("contactJdbcDao")
public class ContactDaoImpl implements ContactDao {
    private JdbcTemplate jdbcTemplate;
    private static final String GET_ALL_CONTACT = "SELECT * FROM contact";
    private static final String INSERT_CONTACT = "INSERT INTO contact (title, relationship, personId, isEmergency, isLandLord, isReference) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public Integer addContact(Contact contact, int personId) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, contact.getTitle());
            statement.setString(2, contact.getRelationship());
            statement.setInt(3, personId);
            statement.setBoolean(4, contact.getIsEmergency());
            statement.setBoolean(5, contact.getIsLandLord());
            statement.setBoolean(5, contact.getIsReference());
            return statement;
        }, holder);
        return holder.getKey().intValue();
    }

    @Override
    public List<Contact> getAllContact() {
        return jdbcTemplate.query(GET_ALL_CONTACT, new BeanPropertyRowMapper<>(Contact.class));
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
