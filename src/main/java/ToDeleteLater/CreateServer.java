package ToDeleteLater;

import com.sun.net.httpserver.*;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CreateServer
{
    public static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange x) throws IOException {
            String person = "person";
            String[] atrib1 = new String[] {"Name", "Joao"};
            String[] atrib2 = new String[] {"Age", "17"};
            String Response = String.format("{" +
                    "%s:{" +
                        "%s:%s," +
                        "%s:%s}}",person, atrib1[0], atrib1[1], atrib2[0], atrib2[1]);
            x.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            x.sendResponseHeaders(200, Response.getBytes().length);
            OutputStream Output_Stream = x.getResponseBody();
            Output_Stream.write(Response.getBytes());
            Output_Stream.close();
        }
    }

    public void fazTudo()
    {
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);
            System.out.println(inetSocketAddress.getAddress().getHostAddress());
            HttpServer httpServer = HttpServer.create(inetSocketAddress, 0);
            httpServer.createContext("/PersonBMI", exchange -> {
                URI uri = exchange.getRequestURI();
                System.out.println(uri.getQuery());
                System.out.println(uri.getRawQuery());
                System.out.println(URLDecoder.decode(uri.getRawQuery(), StandardCharsets.UTF_8));
                String[] argSeparated = uri.getQuery().split("&");
                for (String arg : argSeparated)
                {
                    System.out.println(arg.split("=")[1]);
                }
                String person = "\"person\"";
                String[] atrib1 = new String[] {"\"Name\"", "\"Joao\""};
                String[] atrib2 = new String[] {"\"Age\"", "\"17\""};
                String Response = String.format("{" +
                        "%s:{" +
                        "%s:%s," +
                        "%s:%s}}",person, atrib1[0], atrib1[1], atrib2[0], atrib2[1]);
                exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                exchange.sendResponseHeaders(200, Response.getBytes().length);
                OutputStream Output_Stream = exchange.getResponseBody();
                Output_Stream.write(Response.getBytes());
                Output_Stream.close();
            });
            httpServer.start();
        }
        catch (SecurityException | IOException e)
        {
            e.printStackTrace();
        }
//        try
//        {
//            while (true)
//            {
////                InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName(null), 13000);
////                HttpsServer httpsServer = HttpsServer.create();
////                httpsServer.bind(inetSocketAddress, 0);
////                System.out.println(httpsServer.getAddress().getPort());
////                System.out.println(httpsServer.getAddress().getHostName());
////                System.out.println(httpsServer.getAddress().getAddress());
////                System.out.println(httpsServer.getAddress().getHostString());
//
//
//                ServerSocket serverSocket = new ServerSocket(8888, 1, InetAddress.getByName("100.126.144.79"));
//                InetAddress inetAddress = serverSocket.getInetAddress();
//                if (serverSocket.isBound()) System.out.printf(">>> Server listening to %s:%s\n", inetAddress.getHostAddress(), serverSocket.getLocalPort());
//
//                Socket client = serverSocket.accept();
//
//                /* FROM CLIENT */
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
//                int contentLength = 0;
//                while (true)
//                {
//                    String request = bufferedReader.readLine();
//                    if (request.startsWith("Content-Length")) contentLength = Integer.parseInt(request.split(" ")[1]);
//                    if (request.isBlank()) break;
//                    System.out.println(request);
//                }
//
//                StringBuilder requestBodyBuilder = new StringBuilder();
//                if (contentLength > 0)
//                {
//                    int read;
//
//                    while ((read = bufferedReader.read()) != -1)
//                    {
//                        requestBodyBuilder.append((char) read);
//                        if (requestBodyBuilder.length() == contentLength) break;
//                    }
//
//                    System.out.println(requestBodyBuilder);
//                }
//
//                /* TO CLIENT */
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8));
//                bufferedWriter.write("HTTP 200 OK\r\n");
//                bufferedWriter.write("Content-Type: application/json\r\n");
//                bufferedWriter.write("Allow: GET, POST, HEAD, OPTIONS\r\n");
//                bufferedWriter.write("Access-Control-Allow-Origin: *\r\n"); //TODO: Limitar para aceitar apenas nosso client
//                bufferedWriter.write("\r\n");
//                bufferedWriter.write("{\"title\": \"A New Hope\"}\r\n");
//
//                bufferedWriter.flush();
//                client.close();
//                serverSocket.close();
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
    }
}