package bfs.TeamProj.dao;


import bfs.TeamProj.domain.RegistrationToken;

import java.util.List;

public interface RegistrationTokenDao {
    RegistrationToken getRegistrationTokenByToken(String token);

    RegistrationToken addRegistrationToken(RegistrationToken token);

    List<RegistrationToken> getAllRegistrationToken();
}
