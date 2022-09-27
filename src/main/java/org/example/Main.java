package org.example;
import org.tinylog.Logger;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        after("/*", (req, res) -> Logger.info("[{}] {} {} - {}", req.ip(), req.requestMethod(), req.pathInfo(), res.status()));
        get("/hello", (req, res) -> "Hello World");
        get("/test", (req, res) -> {
            res.status(400);
            return req.ip();
        });
    }
}