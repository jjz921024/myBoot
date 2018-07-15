package edu.gdut.myBoot.dao;

import edu.gdut.myBoot.polo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jun on 2018/7/10.
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

    User findById(long id);

    @Transactional
    long deleteById(long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET name=:name, password=:pw, age=:age WHERE id=:id", nativeQuery = true)
    int updateById(@Param("id") long id, @Param("name") String name, @Param("pw") String password, @Param("age") int age);

    /*Page<User> findAll(Pageable pageable);*/
}
