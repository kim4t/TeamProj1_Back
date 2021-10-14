/*package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.AddressDao;
import bfs.TeamProj.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


public class AddressDaoImpl implements AddressDao {
    private JdbcTemplate jdbcTemplate;
    private static final String GET_ALL_ADDRESS = "SELECT * FROM address";
    private static final String INSERT_ADDRESS = "INSERT INTO address (addressLine1, addressLine2, city, stateAbbr, stateName, zipCode, personId) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    @Override
    public Integer addAddress(Address address, int personId) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_ADDRESS, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, address.getAddressLine1());
            statement.setString(2, address.getAddressLine2());
            statement.setString(3, address.getCity());
            statement.setString(4, address.getStateAbbr());
            statement.setString(5, address.getStateName());
            statement.setString(6, address.getZipCode());
            statement.setInt(7, personId);
            return statement;
        }, holder);
        return holder.getKey().intValue();
    }

    @Override
    public List<Address> getAllAddress() {
        return jdbcTemplate.query(GET_ALL_ADDRESS, new BeanPropertyRowMapper<>(Address.class));
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
*/