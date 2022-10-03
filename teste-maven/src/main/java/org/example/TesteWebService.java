package org.example;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.apache.http.client.fluent.Request;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;

public class TesteWebService {
    public static void main(String[] args) throws IOException {

        String uri = "http://viacep.com.br/ws/87010255/json/";
        String teste = Request.Get(uri)
                .execute()
                .returnContent()
                .asString();

        String saida = "";

        /************* CONVERTENDO XML PARA JSON ******************/
        if (uri.contains("xml")) {
            System.out.println("1");
            Gson gson = new Gson();
            saida = gson.toJson(teste);

            JSONObject json = XML.toJSONObject(teste);
            saida = json.toString(4);

        }
        /*************** CONVERTENDO JSON PARA XML ******************/
        else if(uri.contains("json")) {
            System.out.println("2");
            JSONObject jsonObject = new JSONObject(teste);
            saida = XML.toString(jsonObject);

            //XStream xstream = new XStream();
            //xml = xstream.toXML(json);
            //response.setContentType("application/xml");
            //response.getWriter().print(xml);
        }

        /****************** MOSTRANDO A RESPOSTA *******************/

        System.out.println(saida);
    }
}