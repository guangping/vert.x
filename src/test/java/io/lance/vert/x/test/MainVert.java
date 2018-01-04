package io.lance.vert.x.test;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

/**
 * @author Lance.
 * @time: 2018-01-03 14:21
 * @desc:
 */
public class MainVert {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();

        server.requestHandler(
                req -> req.response().end("Hello World! "+Thread.currentThread().getName())
        );

        server.listen(8080);

    }
}
