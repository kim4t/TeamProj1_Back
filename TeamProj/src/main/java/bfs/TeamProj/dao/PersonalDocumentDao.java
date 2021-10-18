package bfs.TeamProj.dao;

import bfs.TeamProj.domain.PersonalDocument;

import java.util.List;

public interface PersonalDocumentDao {
    PersonalDocument addPersonalDocument(PersonalDocument doc);

    PersonalDocument getPersonalDocumentById(int id);

    List<PersonalDocument> getPersonalDocumentListByEmployeeId(int personId);

    PersonalDocument updatePersonalDocument(PersonalDocument doc);

    PersonalDocument getPersonalDocumentByTitle(String title);
}
