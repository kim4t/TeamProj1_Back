package bfs.TeamProj.dao;


import bfs.TeamProj.domain.RegistrationToken;

import java.util.List;

public interface RegistrationTokenDao {
    RegistrationToken addRegistrationToken(RegistrationToken token);

    List<RegistrationToken> getAllRegistrationToken();


}
