package com.java;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class HttpServer implements HttpHandler {
    static int requestCounter = 0;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String[] requestParams = null;
//        if ("GET".equals(httpExchange.getRequestMethod())) {
//            requestParams = getRequestParams(httpExchange);
//        }
//        if ("POST".equals(httpExchange.getRequestMethod())) {
//            requestParams = getRequestParams(httpExchange);
//        }

        returnResponse(httpExchange, requestParams);
    }

    /**
     * gets params from browser address line
     *
     * @param httpExchange HttpExchange
     * @return address line params
     */
    private String[] getRequestParams(HttpExchange httpExchange) {
        String parameters = httpExchange.getRequestURI().toString().split("\\?")[1];

        String[] params = parameters.split("&");

        return params;
    }

    /**
     * returns response to browser
     *
     * @param httpExchange       HttpExchange
     * @param requestParamValues
     * @throws IOException
     */
    private void returnResponse(HttpExchange httpExchange, String[] requestParamValues) throws IOException {
        requestCounter++;
        System.out.println("Request received: " + requestCounter);
        StringBuilder response = new StringBuilder("");

        OutputStream outputStream = httpExchange.getResponseBody();

//        if (requestParamValues[0].equals("into")){
            response.append(new BufferedReader(new FileReader("src/com/save/api1.txt")).readLine());
//        }

        httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");//разрешаем любой
        httpExchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET");
        httpExchange.sendResponseHeaders(200, response.length());//https://developer.mozilla.org/ru/docs/Web/HTTP/Status

        outputStream.write(response.toString().getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
