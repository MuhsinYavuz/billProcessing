package com.graduationProjectEvam.billProcessing.repo;

import com.graduationProjectEvam.billProcessing.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//anotacion belirtildi.
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
