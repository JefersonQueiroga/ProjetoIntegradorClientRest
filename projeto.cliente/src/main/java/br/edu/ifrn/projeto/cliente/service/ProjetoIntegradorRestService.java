package br.edu.ifrn.projeto.cliente.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.edu.ifrn.projeto.cliente.dto.ProjetoIntegrador;

@RestController
public class ProjetoIntegradorRestService {
	
	
	private static final String URL_API_PROJETOS = "http://projetoifhelp.herokuapp.com/api/projetos";

	
	@Autowired
	private RestTemplate restTemplate;

	
	public ProjetoIntegrador buscarProjetos() {
		
		System.out.println("-------------------");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
			
		
		HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);

		ResponseEntity<ProjetoIntegrador> response = restTemplate.exchange(URL_API_PROJETOS, HttpMethod.GET, httpEntity, ProjetoIntegrador.class);
		
		System.out.println( response.getBody() );
				
		return response.getBody();
	}
	
	
	public List<ProjetoIntegrador> getAll() {	
		try {
			ResponseEntity<ProjetoIntegrador[]> response = this.restTemplate.getForEntity(URL_API_PROJETOS, ProjetoIntegrador[].class);
			if(response.getStatusCodeValue() == 200){
				return Arrays.stream(response.getBody()).collect(Collectors.toList());
			}
		}catch (HttpClientErrorException ex) {
			
			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				return null;
		    }
		}
		return null;
	}

	
}
