package rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class WzyAsynProducer {
    public static final String namesrvIp = "192.168.147.129:9876";
    public static final String groupName = "WzyProducerGroup";
    public static final String topicName = "WzyTopic1";


    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {
        DefaultMQProducer defaultMQProducer=new DefaultMQProducer(groupName);
        defaultMQProducer.setNamesrvAddr(namesrvIp);
        defaultMQProducer.start();
        asynSingleMessage(defaultMQProducer);
        sendOneWay(defaultMQProducer);
        defaultMQProducer.shutdown();
        System.out.println("producer shutdown");
    }

    public static void asynSingleMessage(DefaultMQProducer defaultMQProducer) throws RemotingException, MQClientException, InterruptedException {
        byte[] body="异步发送的消息 my name is yangguo,你好小龙女!".getBytes();
        Message message=new Message(topicName,body);
        defaultMQProducer.send(message,new SendCallback(){

            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult.toString());
                System.out.println("异步消息发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("异步消息发送失败");
            }
        });
    }


    public static void sendOneWay(DefaultMQProducer defaultMQProducer) throws RemotingException, MQClientException, InterruptedException {
        byte[] body="单向发送的消息 my name is yangguo,你好小龙女!".getBytes();
        Message message=new Message(topicName,body);
        defaultMQProducer.sendOneway(message);


    }
}

