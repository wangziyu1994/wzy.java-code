package rocketmq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

public class WzyProducer {
    public static final String namesrvIp="192.168.147.129:9876";
    public static final String groupName="WzyProducerGroup";
    public static final String topicName="WzyTopic1";


    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer defaultMQProducer=new DefaultMQProducer(groupName);
        defaultMQProducer.setNamesrvAddr(namesrvIp);
        defaultMQProducer.start();
        //singleMessageSend(defaultMQProducer);
        singleTagMessage(defaultMQProducer);
       singleTagKeyMessage(defaultMQProducer);
      //  singlePropertyMessage(defaultMQProducer);
       // batchMessageSend(defaultMQProducer);
        defaultMQProducer.shutdown();
        System.out.println("producer shutdown");
    }


    public static void singleMessageSend(DefaultMQProducer defaultMQProducer) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        byte[] body="my name is yangguo,你好小龙女!".getBytes();
        Message message=new Message(topicName,body);
        SendResult sendResult=defaultMQProducer.send(message);
        System.out.println(sendResult.toString());
    }

    public static void singleTagMessage(DefaultMQProducer defaultMQProducer) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        byte[] body="my name is yangguo,你好初音!".getBytes();
        String tagName="动漫";
        Message message=new Message(topicName,tagName,body);
        SendResult sendResult=defaultMQProducer.send(message);
        System.out.println(sendResult.toString());
    }

    public static void singleTagKeyMessage(DefaultMQProducer defaultMQProducer) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        byte[] body="my name is yangguo,你好saber!".getBytes();
        String tagName="动漫";
        String keyName1="fate";
        String keyName2="鬼灭";
        Message message1=new Message(topicName,tagName,keyName1,body);
        Message message2=new Message(topicName,tagName,keyName2,body);
        SendResult sendResult1=defaultMQProducer.send(message1);
        SendResult sendResult2=defaultMQProducer.send(message2);
        System.out.println(sendResult1.toString());
        System.out.println(sendResult2.toString());
    }

    public static void singlePropertyMessage(DefaultMQProducer defaultMQProducer) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        byte[] body="my name is yangguo,你好saber!".getBytes();

        Message message1=new Message(topicName,body);
        message1.putUserProperty("age",String.valueOf(12));
        message1.putUserProperty("name","saber");

        Message message2=new Message(topicName,body);
        message2.putUserProperty("age",String.valueOf(20));
        message2.putUserProperty("name","兰斯洛特");

        SendResult sendResult1=defaultMQProducer.send(message1);
        SendResult sendResult2=defaultMQProducer.send(message2);
        System.out.println(sendResult1.toString());
        System.out.println(sendResult2.toString());
    }

    public static void batchMessageSend(DefaultMQProducer defaultMQProducer) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        List<Message> list=new ArrayList<>();
        for(int i=0;i<=9;i++){
            String s="my name is yangguo,你好小龙女"+i;
            byte[] body=s.getBytes();
            Message message=new Message(topicName,body);
            list.add(message);
        }
        SendResult sendResult=defaultMQProducer.send(list);
        System.out.println(sendResult.toString());
    }




}
