package com.karthik.auditing.repository;



import com.karthik.auditing.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<RegisterUser, Long> {

}
