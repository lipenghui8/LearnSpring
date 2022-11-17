package top.liph.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: lipenghui
 * @create: 2022-11-17 17
 **/
public class RabbitMQUtils {
    public static Channel getChannel() throws IOException, TimeoutException {
        //创建一个连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("192.168.33.30");
        factory.setUsername("admin");
        factory.setPassword("1234");
        //创建连接
        Connection connection=factory.newConnection();
        //获取信道
        Channel channel=connection.createChannel();
        return channel;
    }
}
