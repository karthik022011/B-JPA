package com.learning.sp.repository;



import com.learning.sp.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<RegisterUser, Long> {

}
