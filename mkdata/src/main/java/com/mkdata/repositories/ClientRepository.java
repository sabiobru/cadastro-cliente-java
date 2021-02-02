package com.mkdata.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mkdata.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query(value = "select count(*) as total from client where cpf = :cpf", nativeQuery=true)
    Integer getByCpf(@Param("cpf") String cpf);
	
	@Query(value = "select count(*) as total from client where cnpj = :cnpj", nativeQuery=true)
	Integer getByCnpj(@Param("cnpj") String cnpj);
	
	@Query(value = "SELECT * FROM client WHERE name LIKE %:name% AND status = 1", nativeQuery=true)
	List<Client> filterByName(@Param("name") String name);

		
}
