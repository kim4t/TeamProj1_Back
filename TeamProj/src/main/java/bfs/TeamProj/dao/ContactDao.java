package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Contact;

import java.util.List;

public interface ContactDao {
    Contact addContact(Contact contact);

    List<Contact> getAllContact();

    Contact getContactById(int id);
}
