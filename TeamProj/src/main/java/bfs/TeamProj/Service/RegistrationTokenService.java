package bfs.TeamProj.Service;

import bfs.TeamProj.dao.RegistrationTokenDao;
import bfs.TeamProj.domain.RegistrationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("registrationService")
public class RegistrationTokenService {
    @Autowired
    private RegistrationTokenDao tokenDao;

    @Transactional
    public Integer addToken(RegistrationToken token) {
        return tokenDao.addRegistrationToken(token);
    }

    @Transactional
    public List<RegistrationToken> getAllToken() {
        return tokenDao.getAllRegistrationToken();
    }
}
