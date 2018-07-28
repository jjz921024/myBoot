package edu.gdut.myBoot.dao;

import edu.gdut.myBoot.polo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jun on 2018/7/10.
 *
 */
public interface BookRepository extends JpaRepository<Book, Long>{

    @Modifying
    @Transactional
    @Query(value = "UPDATE book SET name=:name, price=:price, quantity=:quantity, description=:description WHERE id=:id", nativeQuery = true)
    int updateBookById(@Param("id") long id, @Param("name") String name, @Param("price") float price,
                       @Param("quantity") int quantity, @Param("description") String description);


    /*Page<Book> findAll(Pageable pageable);*/
}
