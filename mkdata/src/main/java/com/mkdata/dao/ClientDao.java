package com.mkdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mkdata.entity.Client;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer>{
    @Query(value = "select count(*) as total from client where identityDocument = :identityDocument", nativeQuery=true)
    Integer getByIdentityDocument(@Param("identityDocument") String identityDocument);

    @Query(value = "SELECT * FROM client WHERE nome LIKE %:client% AND status = 0", nativeQuery=true)
    List<Client> filter(@Param("client") String client);

}