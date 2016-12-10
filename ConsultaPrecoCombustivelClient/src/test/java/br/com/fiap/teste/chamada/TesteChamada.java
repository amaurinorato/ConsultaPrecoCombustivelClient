package br.com.fiap.teste.chamada;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.client.model.Cadastro;
import br.com.fiap.client.model.Cadastros;


public class TesteChamada {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/ConsultaPrecoCombustivel").path("combustivelServicesWS").path("consultar");
		
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		String retorno = response.readEntity(String.class);
		System.out.println(retorno);
		
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			//Collection<Cadastros> readValues = new ObjectMapper().readValue(new URL("http://localhost:8080/ConsultaPrecoCombustivel/combustivelServicesWS/consultar"), new TypeReference<Collection<Cadastros>>() { });
			Cadastro obj = mapper.readValue(new URL("http://localhost:8080/ConsultaPrecoCombustivel/combustivelServicesWS/consultar"), Cadastro.class);
			//for (Cadastro cadastro : obj.getCadastro()) {
				//System.out.println(cadastro.getCombustivel());
			//}
			Cadastro cadastro = mapper.readValue(new URL("http://localhost:8080/ConsultaPrecoCombustivel/combustivelServicesWS/1"), Cadastro.class);
			System.out.println(cadastro.getValor());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
