package Network;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import model.service.view.HttpView;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class Server
{
    HttpServer httpServer;
    String address;
    int port;

    public Server(String address, int port)
    {
        this.address = address;
        this.port = port;

        try {
            httpServer = HttpServer.create(new InetSocketAddress(address, port), 0);
            System.out.println(">>> Bound to " + httpServer.getAddress().getAddress().getHostAddress() + ":" + httpServer.getAddress().getPort());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void addResponseForPath(String path, HttpHandler httpHandler)
    {
        httpServer.createContext(path, httpHandler);
    }

    public void addResponseForPath(Map<String, HttpHandler> responses)
    {
        for (var entry: responses.entrySet())
        {
            httpServer.createContext(entry.getKey(), entry.getValue());
        }
    }

    public void addResponseForPath(List<HttpView> responses)
    {
        for (HttpView httpView : responses)
        {
            httpServer.createContext(httpView.getPath(), httpView.getHttpHandler());
        }
    }

    public void startListening()
    {
        httpServer.start();
        System.out.println(">>> Listening for requests...");
    }
}
