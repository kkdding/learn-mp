package com.ding.learnmp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.ding.learnmp.mapper.UserMapper;
import com.ding.learnmp.model.entity.User;
import com.ding.learnmp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@SpringBootTest
class LearnMpApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        // 假设有一个 User 实体对象
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        boolean result = userService.save(user); // 调用 save 方法
        if (result) {
            System.out.println("User saved successfully.");
        } else {
            System.out.println("Failed to save user.");
        }
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setName("Jane");
        user.setEmail("test1@baomidou.com");
        user.setAge(188);
        userService.updateById(user);
        System.out.println("Success");
    }

    @Test
    public void testUpdate2() {
        User user = new User();
        user.setName("James");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1L);
        userService.update(user, queryWrapper);
        System.out.println("Success");
    }

    @Test
    public void testDelete() {
        // 假设有一个 QueryWrapper 对象，设置删除条件为 name = 'John Doe'
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "John Doe");
        boolean result = userService.remove(queryWrapper); // 调用 remove 方法
        if (result) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Failed to delete record.");
        }
    }

    @Test
    public void testGet() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "Tom");
        User user = userService.getOne(queryWrapper, false); // 调用 getOne 方法
        if (user != null) {
            System.out.println("User found: " + user.getEmail());
        } else {
            System.out.println("User not found.");
        }
    }

    @Test
    public void testCommon() {
        int[] array = {7, -2, 3, 5, -9, 3, -5, -1, 6, 8, 20};
        Arrays.stream(array)
                .filter((int a) -> a >= 0)    //过滤
                .filter(b -> b % 2 == 0)
                .sorted()               //排序
                .forEach(System.out::println);
        int a = 1;
        int b = -1;
        Predicate<Integer> predicate = i -> i >= 0;
        System.out.println(predicate.test(a));  //true
        System.out.println(predicate.test(b));  //false
    }

    @Test
    public void testCount() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "James");
        long count = userService.count(queryWrapper);
        System.out.println("Count: " + count);
    }
}
