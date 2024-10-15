package com.honor.infrastructure.conf.websocket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;


/**
 * @author honor
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    private final WebSocketInterceptor webSocketInterceptor;

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry.setMessageSizeLimit(2048 * 2048);
        registry.setSendBufferSizeLimit(2048 * 2048);
        registry.setSendTimeLimit(2048 * 2048);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /**
         * 注册 Stomp的端点
         * addEndpoint：添加STOMP协议的端点。这个HTTP URL是供WebSocket或SockJS客户端访问的地址
         * withSockJS：指定端点使用SockJS协议
         */
        registry.addEndpoint("/stomp/endpoint")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        WebSocketMessageBrokerConfigurationSupport
        /**
         * 配置消息代理
         * 启动简单Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
         */
        registry.enableSimpleBroker("/queue", "/topic");
        registry.setApplicationDestinationPrefixes("/app");
        registry.setUserDestinationPrefix("/user");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(webSocketInterceptor);
    }

}
