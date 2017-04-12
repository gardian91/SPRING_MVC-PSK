package com.psk.bank.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.psk.bank.model.User;

public class ExampleClientTest {

	private static String url;
	private static RestTemplate restTemplate = new RestTemplate();

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		restTemplate = new RestTemplate();
		url = "http://localhost:8080/";
	}
	
	@Test
    public void getWithPathVariableExampleShouldReturnUserWithId() {
		
		
		ResponseEntity<User> response = restTemplate.exchange(url + "getUserWithGivenId/{id}", HttpMethod.GET, null,
				User.class, "2");
		
		
		assertThat(response).isNotNull();
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getId()).isEqualTo("2");
		//assertThat(response.getBody().getName()).isEqualTo(200);
	}
	
	@Test
    public void deleteWithPathVariableExampleShouldReturnDeletedUser() {
		ResponseEntity<User> response = restTemplate.exchange(url + "deleteUserWithGivenId/{id}", HttpMethod.DELETE, null, User.class, "1");
		
		assertThat(response).isNotNull();
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getId()).isEqualTo("1");
	}
	
	@Test
    public void postMethodExampleShouldReturnString() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("id", "1");
		map.add("name", "NewUser");
		map.add("date", "2017-01-02T21:32:00");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(url+"addUser", request, String.class);
		
		assertThat(response).isNotNull();
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody()).isEqualTo("User added successfully");
	}
	
	@Test
    public void getWithPathVariableExampleShouldReturnUserDeletedWithDate() {
		
		
		ResponseEntity<User> response = restTemplate.exchange(url + "getUserWithGivenId/{id}", HttpMethod.GET, null,
				User.class, "2");
		
		
		assertThat(response).isNotNull();
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getDate()).isEqualTo("2");
		//assertThat(response.getBody().getName()).isEqualTo(200);
	}

}
