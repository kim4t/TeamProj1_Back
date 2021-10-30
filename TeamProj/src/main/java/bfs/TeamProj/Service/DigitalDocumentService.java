package bfs.TeamProj.Service;

import bfs.TeamProj.dao.DigitalDocumentDao;
import bfs.TeamProj.domain.DigitalDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DigitalDocumentService {
    @Autowired
    private DigitalDocumentDao digitalDocumentDao;

    @Transactional
    public DigitalDocument addDigitalDocument(DigitalDocument document){
        return digitalDocumentDao.addDigitalDocument(document);
    }

    @Transactional
    public List<DigitalDocument> getAllDigitalDocument() {
        return digitalDocumentDao.getAllDigitalDocument();
    }

    @Transactional
    public DigitalDocument getDigitalDocumentById(int id){
        return digitalDocumentDao.getDigitalDocumentById(id);
    }
}
