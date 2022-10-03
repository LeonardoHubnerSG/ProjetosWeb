package br.com.alura.cliente;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		String teste = Request.Get("http://viacep.com.br/ws/87010255/json/")
	    .execute()
	    .returnContent()
	    .asString();
		
	    
		/*
	    String teste = Request.Post("http://viacep.com.br/ws/87113160/json")
	    .bodyForm(Form.form().add("username",  "vip").add("password",  "secret").build())
	    .execute()
	    .returnContent().asString();
	    */
	    
	    System.out.println(teste);

	}
	
//	public static void servicoDeCep() {
//	     String webService = "http://viacep.com.br/ws/";
//	     int codigoSucesso = 200;
//	     String cep = "87113160";
//	     String urlParaChamada = webService + cep + "/json";
//
//    
//         URL url = new URL(urlParaChamada);
//         HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
//
//         if (conexao.getResponseCode() != codigoSucesso)
//             throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
//
//         BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
//         String jsonEmString = Util.converteJsonEmString(resposta);
//
//         Gson gson = new Gson();
//         Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);
//
//         System.out.println(endereco); 
//	    
//	}
//	
//	public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
//        String resposta, jsonEmString = "";
//        while ((resposta = buffereReader.readLine()) != null) {
//            jsonEmString += resposta;
//        }
//        return jsonEmString;
//    }

}
