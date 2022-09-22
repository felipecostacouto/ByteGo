package view;

import model.service.PersonService;
import model.service.view.HttpView;
import view.URL.URLParameters;

import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PersonView
{
//    PersonService personService;
//    List<HttpView> handlers = new LinkedList<>();
//
//    public PersonView(PersonService personService)
//    {
//        this.personService = personService;
//        createHandlers();
//    }
//
//    private void createHandlers()
//    {
//        handlers.add(getBMIHandler());
//    }
//
//    public List<HttpView> getHandlers()
//    {
//        return handlers;
//    }
//
//    /*
//    *
//    *   Person Handlers
//    *
//    * */
//
//    private HttpView getBMIHandler()
//    {
//        return new HttpView("/Person/getBMI", exchange -> {
//            Map<String, Object> parameters = URLParameters.getQueryParameters(exchange.getRequestURI());
//            double personBMI = personService.getBMI((String)parameters.get("name"));
//            String responseJSON = "{\"BMI\":\"" + personBMI + "\"}";
//            byte[] responseBytes = responseJSON.getBytes();
//
//            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
//            exchange.sendResponseHeaders(200, responseBytes.length);
//
//            OutputStream Output_Stream = exchange.getResponseBody();
//            Output_Stream.write(responseBytes);
//            Output_Stream.close();
//        });
//    }

}
