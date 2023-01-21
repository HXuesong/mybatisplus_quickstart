package com.hxs;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxs.dao.UserDao;
import com.hxs.domain.User;
import com.hxs.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisplusQuickstartApplicationTests {
	@Autowired
	private UserDao userDao;

	@Test
	void testSave() {
		User user = new User();
		user.setName("hxs");
		user.setPassword("1234");
		user.setAge(18);
		user.setTel("1836630");
		userDao.insert(user);
	}

	@Test
	void testDelete() {
//		List<Long> list = new ArrayList<>();
//		list.add(3L);
//		list.add(4L);
//		userDao.deleteBatchIds(list);
		userDao.deleteById(1L);
	}

	@Test
	void testUpdate() {
		User user = new User();
		user.setId(1L);
		user.setName("hxs");
		userDao.updateById(user);
	}

	@Test
	void testGetById() {
		User user = userDao.selectById(2L);
		System.out.println(user);
	}

	@Test
	void testGetByPage() {
		IPage page = new Page(1, 2);
		userDao.selectPage(page, null);
		System.out.println(page.getRecords());
	}

	@Test
	void testGetAll() {
//		UserQuery uq = new UserQuery();
//		uq.setAge(4);
//		uq.setAge2(15);
//
//		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//		lambdaQueryWrapper.lt(null != uq.getAge(), User::getAge, uq.getAge());
//		lambdaQueryWrapper.or().gt(null != uq.getAge2(), User::getAge, uq.getAge2());
//		List<User> users = userDao.selectList(lambdaQueryWrapper);
//		System.out.println(users);

//		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//		queryWrapper.select("count(*) as count");
//		List<Map<String, Object>> userList = userDao.selectMaps(queryWrapper);
//		System.out.println(userList);

//		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//		lambdaQueryWrapper.eq(User::getName, "Jerry").eq(User::getPassword, "jerry");
//		User user = userDao.selectOne(lambdaQueryWrapper);
//		System.out.println(user);

		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//		lambdaQueryWrapper.between(User::getAge, 10, 30);
//		lambdaQueryWrapper.like(User::getName, "J");
		List<User> users = userDao.selectList(lambdaQueryWrapper);
		System.out.println(users);
	}
}
