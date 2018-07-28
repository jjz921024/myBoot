package edu.gdut.myBoot.dao;

import com.alibaba.fastjson.JSON;
import edu.gdut.myBoot.polo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Jun on 2018/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void test() {
        List<Book> all = bookRepository.findAll();
        System.out.println(all.get(0).toString());
        System.out.println(JSON.toJSON(all));
    }

    @Test
    public void testPageQuery() {
        int page=1;
        int size=2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);

        //todo: 没有分页
        Page<Book> page1 = bookRepository.findAll(pageable);
        List<Book> content1 = page1.getContent();
        System.out.println(content1.toString());

        Page<Book> page2 = bookRepository.findAll(pageable.next());
        List<Book> content = page2.getContent();
        System.out.println(content.toString());
    }
}
