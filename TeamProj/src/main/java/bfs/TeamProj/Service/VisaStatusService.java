package bfs.TeamProj.Service;

import bfs.TeamProj.dao.VisaStatusDao;
import bfs.TeamProj.domain.VisaStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VisaStatusService {
    private VisaStatusDao visaStatusDao;

    @Transactional
    public VisaStatus addVisaStatus(VisaStatus visaStatus) {
        return visaStatusDao.addVisaStatus(visaStatus);
    }

    @Transactional
    public VisaStatus getVisaStatusById(int id) {
        return visaStatusDao.getVisaStatusById(id);
    }


    @Autowired
    public void setVisaStatusDao(VisaStatusDao visaStatusDao) {
        this.visaStatusDao = visaStatusDao;
    }
}
