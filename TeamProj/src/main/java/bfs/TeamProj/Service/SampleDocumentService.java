package bfs.TeamProj.Service;

import bfs.TeamProj.dao.DigitalDocumentDao;
import bfs.TeamProj.domain.DigitalDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SampleDocumentService {
    @Autowired
    private DigitalDocumentDao documentDao;

    @Transactional
    public Integer addSampleDocument(DigitalDocument doc) {
        return documentDao.addDigitalDocument(doc);
    }

    @Transactional
    public List<DigitalDocument> getAllSampleDocument() {
        return documentDao.getAllDigitalDocument();
    }
}
