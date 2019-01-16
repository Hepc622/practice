package com.example.demo;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;
import javax.xml.soap.Text;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeignApplicationTests {
    @Test
    public void contextLoads() {
        /*连接工厂*/
        ActiveMQConnectionFactory factory = null;
        /*连接*/
        Connection connection = null;
        /*session会话*/
        Session session = null;
        /*存放消息的队列*/
        Queue message = null;
        /*消息发送者*/
        MessageConsumer consumer = null;

        try {
            /*创建连接工程*/
            /*String userName, String password, URI brokerURL*/
            factory = new ActiveMQConnectionFactory(
                    ActiveMQConnectionFactory.DEFAULT_USER,
                    ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                    "tcp://192.168.0.104:61616");
            /*获取连接*/
            connection = factory.createConnection();
            /*启动连接*/
            connection.start();
            /*创建session
            * 参数1 是否开启事务
            * 参数2 使用什么通知模式*/
            session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            /*创建消息队列名字*/
            message = session.createQueue("message");
           /*创建消息消费者*/
            consumer = session.createConsumer(message);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        message.acknowledge();
                        TextMessage textMessage = (TextMessage) message;
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                /*关闭所有连接*/
                if (consumer != null)
                    consumer.close();
                if (session != null)
                    session.close();
                if (connection != null)
                    connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
