package bfs.TeamProj.dao;

import bfs.TeamProj.domain.DigitalDocument;

import java.util.List;

public interface DigitalDocumentDao {
    Integer addDigitalDocument(DigitalDocument doc);

    List<DigitalDocument> getAllDigitalDocument();
}
