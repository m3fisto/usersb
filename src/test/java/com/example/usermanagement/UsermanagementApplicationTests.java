package com.example.usermanagement;

import com.example.usermanagement.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsermanagementApplicationTests {

@Autowired
	private TestRestTemplate testRestTemplate;
	@Test
	public void createUser() {
		UserDto userDto = new UserDto();
		userDto.setFirstName("parikios");
		userDto.setEmail("a@a.a");
		userDto.setLastname("gfdgfdgfd");
		HttpEntity<UserDto> httpEntity = new HttpEntity<>(userDto);
		ResponseEntity<UserDto> responseEntity = testRestTemplate.exchange("/user", HttpMethod.POST, httpEntity, UserDto.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		UserDto returnedUserDto = responseEntity.getBody();
		assertEquals("a@a4.a", returnedUserDto.getEmail());
	}

}
