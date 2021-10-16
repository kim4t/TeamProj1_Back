package bfs.TeamProj.dao;

import bfs.TeamProj.domain.PersonalDocument;

import java.util.List;

public interface PersonalDocumentDao {
    PersonalDocument addPersonalDocument(PersonalDocument doc);

    List<PersonalDocument> getPersonalDocumentListByEmployeeId(int personId);
}
