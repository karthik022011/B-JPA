package com.learning.sp.repository;



import com.learning.sp.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<RegisterUser, Long> {
    @Query(value = "CALL get_all_users()", nativeQuery = true)
   // @Procedure(name = "get_all_users()") //not working
    List<RegisterUser> getAllUsers();
}
