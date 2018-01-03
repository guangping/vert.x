package io.lance.vert.x.test;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * @author Lance.
 * @time: 2018-01-03 14:39
 * @desc:
 */
public class RestServer extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        // 部署发布rest服务
        vertx.deployVerticle(new RestServer());
    }


    @Override
    public void start() throws Exception {
        // 实例化一个路由器出来，用来路由不同的rest接口
        Router router = Router.router(vertx);

        // 增加一个处理器，将请求的上下文信息，放到RoutingContext中
        router.route().handler(BodyHandler.create());

        //post处理
        router.post("/a").blockingHandler(this::handlePost);

       /* router.get("/b").blockingHandler(handler -> {

        });*/
        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }

    //处理post请求
    private void handlePost(RoutingContext context) {
        String param1 = context.request().getParam("param1");


        context.response().end();
    }
}
