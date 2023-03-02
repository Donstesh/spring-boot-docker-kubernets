package com.example.ErrorHandling;

import com.example.ErrorHandling.entity.Users;
import com.example.ErrorHandling.repository.UsersRepository;
import com.example.ErrorHandling.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ErrorHandlingApplicationTests {
	@Autowired
	private UserService userService;
	@MockBean
	private UsersRepository usersRepository;

	@Test
	void contextLoads() {
	}
	@Test
	void testUserExist(){
		//given
		String userName = "Joy Ruth";
		Users users = new Users(
				1,
				userName,
				"TECH",
				"7627 TZ"
		);
		userService.saveUser(users);
		//when
//		Boolean exists = userService.saveUser();
		//then
		assertThat(userName).isEqualTo("Tony Specs");
	}


//
//	public void getUsersTest(){
//		when(usersRepository.findAll()).thenReturn(Stream.
//				of(new Users(1, "7627 TZ", "TECH", "Joy Ruth" )).collect(Collectors.toList()));
//
//	}
}
