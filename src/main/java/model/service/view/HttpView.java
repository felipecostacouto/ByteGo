package model.service.view;

import com.sun.net.httpserver.HttpHandler;

public class HttpView
{
    private final String path;
    private final HttpHandler httpHandler;

    public HttpView(String path, HttpHandler httpHandler)
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
