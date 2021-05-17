package rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;

public class DefaultPullConsumerTest {
    public static final String namesrvIp = "192.168.147.129:9876";
    public static final String groupName = "WzyConsumerGroup";
    public static final String topicName = "WzyTopic1";
    public static void main(String[] args) throws MQClientException {
        DefaultMQPullConsumer defaultMQPullConsumer = new DefaultMQPullConsumer(groupName);
        defaultMQPullConsumer.start();
    }
}
