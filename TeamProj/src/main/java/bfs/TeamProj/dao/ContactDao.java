package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Contact;

import java.util.List;

public interface ContactDao {
    Integer addContact(Contact contact, int personId);

    List<Contact> getAllContact();
}
