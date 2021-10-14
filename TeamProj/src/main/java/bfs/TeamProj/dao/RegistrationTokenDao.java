package bfs.TeamProj.dao;


import bfs.TeamProj.domain.RegistrationToken;

import java.util.List;

public interface RegistrationTokenDao {
    Integer addRegistrationToken(RegistrationToken token);
    RegistrationToken getRegistrationTokenByToken(String token);
    List<RegistrationToken> getAllRegistrationToken();
}
