package com.psk.bank.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.psk.bank.model.Account;
import com.psk.bank.model.AccountEntity;
import com.psk.bank.model.User;

public class ExampleClient {

	private String url;
	private RestTemplate restTemplate = new RestTemplate();

	public ExampleClient(String url) {
		this.url = url;
	}

	public ResponseEntity<User> postMethodExample(String id, String name) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("id", id);
		map.add("name", name);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		return restTemplate.postForEntity(url+"postWithParamExample", request, User.class);

	}

	public ResponseEntity<User> deleteMethodExample(String id) {

		return restTemplate.exchange(url + "deleteWithPathVariableExample/{id}", HttpMethod.DELETE, null, User.class, id);

	}

	public ResponseEntity<User> getMethodExample(String id) {

		return restTemplate.exchange(url + "getWithPathVariableExample/{id}", HttpMethod.GET, null,
				User.class, id);
	}

	public String pathVariableExample() {
		return "";
	}

	//// http://localhost:8080/requestParamExample?id=testId&name=testName

	public String requestParamExample() {

		return "";
	}

}
