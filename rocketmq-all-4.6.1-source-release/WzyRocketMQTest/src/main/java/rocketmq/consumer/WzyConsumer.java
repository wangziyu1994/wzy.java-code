package rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class WzyConsumer {
    public static final String namesrvIp = "192.168.147.129:9876";
    public static final String groupName = "WzyConsumerGroup";
    public static final String topicName = "WzyTopic1";

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer(groupName);
        DefaultMQPullConsumer defaultMQPullConsumer = new DefaultMQPullConsumer(groupName);
        defaultMQPullConsumer.setNamesrvAddr(namesrvIp);
        //consumerSingleMethod(defaultMQPullConsumer);
        consumerTagMethod(defaultMQPushConsumer);
        consumerTagKeyMethod(defaultMQPushConsumer);
        defaultMQPushConsumer.start();
        defaultMQPullConsumer.start();

    }

    public static void consumerSingleMethod(DefaultMQPushConsumer defaultMQPushConsumer) throws MQClientException {
        defaultMQPushConsumer.subscribe(topicName, "*");
        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
            list.forEach((e)->{
                byte[] resmsg=null;
                String restr=null;
                resmsg=e.getBody();
                try {
                    restr=new String(resmsg, "UTF-8");
                    System.out.println(restr);
                } catch (UnsupportedEncodingException unsupportedEncodingException) {
                    unsupportedEncodingException.printStackTrace();
                }
            });
            defaultMQPushConsumer.shutdown();
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
    });
    }



    public static void consumerTagMethod(DefaultMQPushConsumer defaultMQPushConsumer) throws MQClientException {
        defaultMQPushConsumer.subscribe(topicName,"动漫");
        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                list.forEach((e) -> {
                    byte[] resmsg = null;
                    String restr = null;
                    resmsg = e.getBody();
                    try {
                        restr = new String(resmsg, "UTF-8");
                        System.out.println(restr);
                    } catch (UnsupportedEncodingException unsupportedEncodingException) {
                        unsupportedEncodingException.printStackTrace();
                    }
                });
               // defaultMQPushConsumer.shutdown();
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
    }


    public static void consumerTagKeyMethod(DefaultMQPushConsumer defaultMQPushConsumer) throws MQClientException {
        defaultMQPushConsumer.subscribe(topicName,"动漫.fate");
        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                list.forEach((e) -> {
                    byte[] resmsg = null;
                    String restr = null;
                    resmsg = e.getBody();
                    try {
                        restr = new String(resmsg, "UTF-8");
                        System.out.println(restr);
                    } catch (UnsupportedEncodingException unsupportedEncodingException) {
                        unsupportedEncodingException.printStackTrace();
                    }
                });
               // defaultMQPushConsumer.shutdown();
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
    }


    public static void consumerUserPropertyMethod(DefaultMQPushConsumer defaultMQPushConsumer) throws MQClientException {
        defaultMQPushConsumer.subscribe(topicName,"动漫");
        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                list.forEach((e) -> {
                    byte[] resmsg = null;
                    String restr = null;
                    resmsg = e.getBody();
                    try {
                        restr = new String(resmsg, "UTF-8");
                        System.out.println(restr);
                    } catch (UnsupportedEncodingException unsupportedEncodingException) {
                        unsupportedEncodingException.printStackTrace();
                    }
                });
                //defaultMQPushConsumer.shutdown();
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
    }

}
