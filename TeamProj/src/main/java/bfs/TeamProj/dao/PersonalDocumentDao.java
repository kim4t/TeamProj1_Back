package bfs.TeamProj.dao;

import bfs.TeamProj.domain.PersonalDocument;

import java.util.List;

public interface PersonalDocumentDao {
    Integer addPersonalDocument(PersonalDocument doc, int EmployeeId);

    List<PersonalDocument> getPersonalDocumentListById(int id);
}
