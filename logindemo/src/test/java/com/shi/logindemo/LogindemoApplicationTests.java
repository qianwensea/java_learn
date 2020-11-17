package com.shi.logindemo;

import com.shi.logindemo.dao.IUserDao;
import com.shi.logindemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.List;

@SpringBootTest
class LogindemoApplicationTests {

	@Autowired
	private IUserDao userDao;

	@Test
	void saveUser() {
		User user = new User("aze","123456");
		String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		String md5Username = DigestUtils.md5DigestAsHex(user.getUsername().getBytes());
		user.setPassword(md5Password);
		user.setUsername(md5Username);
		userDao.saveUser(user);
	}

	@Test
	void findAll(){
		List<User> users = userDao.findAll();
		for (User user:users){
			System.out.println(user);
		}
	}
}
