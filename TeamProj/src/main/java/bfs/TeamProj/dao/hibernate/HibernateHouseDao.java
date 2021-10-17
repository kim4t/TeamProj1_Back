package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.HouseDao;
import bfs.TeamProj.domain.House;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateHouseDao extends AbstractHibernateDAO<House> implements HouseDao {
    public HibernateHouseDao() {
        setClazz(House.class);
    }

    @Override
    public List<House> getAllHouse() {
        return findAll();
    }

    @Override
    public House getHouseById(int id) {
        return findById(id);
    }

    @Override
    public House addHouse(House house) {
        return create(house);
    }

}

