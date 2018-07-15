package edu.gdut.myBoot.dao;

import com.alibaba.fastjson.JSON;
import edu.gdut.myBoot.polo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
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
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        List<User> all = userRepository.findAll();
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
        Page<User> page1 = userRepository.findAll(pageable);
        List<User> content1 = page1.getContent();
        System.out.println(content1.toString());

        Page<User> page2 = userRepository.findAll(pageable.next());
        List<User> content = page2.getContent();
        System.out.println(content.toString());
    }
}
