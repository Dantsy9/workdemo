package com.ffcs.mpper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ffcs.entity.Human;
import com.ffcs.entity.MultiEntity;
import com.ffcs.entity.Work;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class AllTestCase {

    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private HumanMapper humanMapper;

    /**
     * 基本CRUD
     */
    @Test
    void testInsert(){
        Work work = new Work();
        work.setGender(0);
        work.setUsername("ljj");
        work.setPassword("root");
        work.setRealName("admin");
        workMapper.insert(work);
    }


    @Test
    void testselectByName(){
        LambdaQueryWrapper<Work> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Work::getUsername,"ljj");

    }

    @Test
    void testupdateByName(){
        Work work = new Work();
        work.setGender(0);
        work.setUsername("LDH");
        LambdaQueryWrapper<Work> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Work::getUsername,"ljj");

    }

    /**
     * 逻辑删除
     */
    @Test
    void testDeleteByUsername(){
        LambdaQueryWrapper<Work> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Work::getUsername,"ljj");

        int delete = workMapper.delete(wrapper);
    }


    /**
     * 事务
     */

    @Test
    @Transactional
    @Rollback(false)
    void testTransactional(){
        Human human = new Human();
        human.setUsername("LYX");
        human.setBirthday("1878");
        human.setLocal("China");

        humanMapper.insert(human);

        Work work = new Work();
        work.setGender(0);
        work.setUsername("LYX");
        work.setPassword("root");
        work.setRealName("user");
        workMapper.insert(work);
    }

    /**
     * 乐观锁
     */

    @Test
    void testOptLock(){
        LambdaQueryWrapper<Human> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Human::getUsername,"ZJL");
        Human human = humanMapper.selectOne(wrapper);
        human.setUsername("ZJLLL");
        humanMapper.update(human,wrapper);
    }

    /**
     * 多表查询
     */

    @Test
    void testDBCX(){
        List<MultiEntity> res = workMapper.multiSelectAll("LYX");
        System.out.println(res);
    }
}
