package edu.gdut.myBoot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.gdut.myBoot.dao.UserRepository;
import edu.gdut.myBoot.polo.ErrorInfo;
import edu.gdut.myBoot.polo.User;
import edu.gdut.myBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jun on 2018/7/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String getAllUser() {
        List<User> list = userRepository.findAll();
        return JSON.toJSON(list).toString();
    }

    @Override
    public String findUserById(long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            JSONObject jsonObject = new JSONObject();
            ErrorInfo errorInfo = new ErrorInfo(500, "not find", "unkonwn");
            jsonObject.put("error", errorInfo);
            return jsonObject.toJSONString();
        }
        return JSON.toJSONString(user);
    }

    @Override
    public String addUser(User user) {
        User save;
        try {
            // 不管插入与否，返回待添加的对象
            save = userRepository.save(user);
        } catch (RuntimeException e) {
            JSONObject jsonObject = new JSONObject();
            ErrorInfo errorInfo = new ErrorInfo(500, "add error", "unkonwn");
            jsonObject.put("error", errorInfo);
            return jsonObject.toJSONString();
        }
        return JSON.toJSONString(save);
    }

    @Override
    public String updateUserById(long id, User user) {
        int updatedNum;
        try {
            updatedNum = userRepository.updateById(id, user.getName(), user.getPassword(), user.getAge());
        } catch (RuntimeException e) {
            JSONObject jsonObject = new JSONObject();
            ErrorInfo errorInfo = new ErrorInfo(500, "update error", "unkonwn");
            jsonObject.put("error", errorInfo);
            return jsonObject.toJSONString();
        }
        return JSON.toJSONString(updatedNum);
    }

    @Override
    public String deleteUserById(long id) {
        //返回删除数
        long deletedNum = userRepository.deleteById(id);
        if (deletedNum <= 0) {
            JSONObject jsonObject = new JSONObject();
            ErrorInfo errorInfo = new ErrorInfo(500, "not delete", "unkonwn");
            jsonObject.put("error", errorInfo);
            return jsonObject.toJSONString();
        }
        return JSON.toJSONString(deletedNum);
    }
}
