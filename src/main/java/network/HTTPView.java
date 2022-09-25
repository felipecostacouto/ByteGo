package network;

import com.sun.net.httpserver.HttpHandler;

public class HTTPView
{
    private final String path;
    private final HttpHandler httpHandler;

    public HTTPView(String path, HttpHandler httpHandler)
    {
        this.path = path;
        this.httpHandler = httpHandler;
    }

    public String getPath()
    {
        return path;
    }

    public HttpHandler getHttpHandler()
    {
        return httpHandler;
    }
}
