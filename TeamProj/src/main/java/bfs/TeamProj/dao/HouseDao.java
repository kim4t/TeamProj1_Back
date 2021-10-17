package bfs.TeamProj.dao;

import bfs.TeamProj.domain.House;

import java.util.List;

public interface HouseDao {

    House getHouseById(int id);

    List<House> getAllHouse();

    House addHouse(House house);
}
