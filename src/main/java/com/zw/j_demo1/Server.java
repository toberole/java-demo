package com.zw.j_demo1;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.zw.bean.Student;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Server {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.name = "Hello-" + System.currentTimeMillis();
            student.age = (int) (System.currentTimeMillis() % 100);
            System.out.println(gson.toJson(student));

            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8001), 0);
            httpServer.createContext("/", new TestHandler());
            httpServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class TestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.println("Hello Client ......");
            exchange.sendResponseHeaders(200, 0);
            OutputStream outputStream = exchange.getResponseBody();
            Student student = new Student();
            student.name = "Hello-" + System.currentTimeMillis();
            student.age = (int) (System.currentTimeMillis() % 100);
            outputStream.write(gson.toJson(student).getBytes(StandardCharsets.UTF_8));
        }
    }
}
