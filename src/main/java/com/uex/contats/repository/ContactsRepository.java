package com.uex.contats.repository;

import com.uex.contats.domain.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactsRepository extends JpaRepository<Contacts,Long> {
    Contacts findByCpf(Integer cpf);
    @Query(nativeQuery = true, value = "SELECT c.* FROM contacts c WHERE c.name LIKE %?%;")
    List<Contacts> findByName(String name);
}
