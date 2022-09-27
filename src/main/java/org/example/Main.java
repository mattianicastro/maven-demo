package org.example;


import org.tinylog.Logger;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        before("/*", (req, res) -> Logger.info("[{}] {} - {}", req.ip(), req.requestMethod(), req.pathInfo()));
        get("/hello", (req, res) -> "Hello World");
        post("/test", (req, res) -> {
            Logger.trace(req);
            return req.ip();
        });
    }
}