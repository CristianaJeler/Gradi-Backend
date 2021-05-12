package com.gradi.app.utilities;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.standard.TomcatRequestUpgradeStrategy;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

//@EnableWebSocketMessageBroker
//@Configuration
@ServerEndpoint("/proba")
public class WebSocketConfig{
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//
//    }
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry
//                                               registry) {
//        registry.addEndpoint("/gradi")
//                .setAllowedOrigins("*");
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config){
//        config.enableSimpleBroker("/topic/", "/queue/");
//        config.setApplicationDestinationPrefixes("/teachers");
//    }

//    public DefaultHandshakeHandler handshakeHandler() {
//        return new DefaultHandshakeHandler(new TomcatRequestUpgradeStrategy());
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/gradi")
//                .setHandshakeHandler(handshakeHandler())
//                .setAllowedOrigins("*")
//                .addInterceptors(new HandshakeInterceptor() {
//
//                    @Override
//                    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
//                                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//                        return request.getHeaders().getOrigin() != null;
//                    }
//
//                    @Override
//                    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
//                                               WebSocketHandler wsHandler, Exception exception) {
//
//                    }
//
//                });
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry configurer) {
//        configurer.setApplicationDestinationPrefixes("/gradi")
//                .enableSimpleBroker("/topic", "/queue");
//    }

    @OnOpen
    public void handleOpen(){
        System.out.println("client is connected...");
    }

    @OnMessage
    public String handleMessage(String message){
        System.out.println(message);
        return "hi, "+message;
    }

    @OnClose
    public void handleClose(){
        System.out.println("client is disconnected...");
    }

    @OnError
    public void handleError(Throwable t){
        t.printStackTrace();
    }
}