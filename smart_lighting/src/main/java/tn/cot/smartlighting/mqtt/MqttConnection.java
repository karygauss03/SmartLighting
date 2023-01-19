package tn.cot.smartlighting.mqtt;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import tn.cot.smartlighting.repositories.LightingModuleRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.net.ssl.SSLSocketFactory;
import javax.sql.ConnectionEventListener;

@Singleton
@Startup
public class MqttConnection {
    @Inject
    private LightingModuleRepository lightingModuleRepository;

    private static final Config config = ConfigProvider.getConfig();
    private final String uri = config.getValue("mqtt.uri", String.class);
    private final String username = config.getValue("mqtt.username", String.class);
    private final String password = config.getValue("mqtt.password", String.class);

    public void sendMessage(MqttClient client, String msg, String topic) throws MqttException {
        MqttMessage message = new MqttMessage(msg.getBytes());
        client.publish(topic,message);
    }

    @PostConstruct
    public void start() {
        try {
            System.out.println("\n **************** \n");
            System.out.println("MQTT CONNECTED");
            System.out.println("\n **************** \n");

            MqttClient client = new MqttClient(
                    uri,
                    MqttClient.generateClientId(),
                    new MemoryPersistence());

            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setUserName(username);
            mqttConnectOptions.setPassword(password.toCharArray());
            mqttConnectOptions.setConnectionTimeout(0);
            mqttConnectOptions.setSocketFactory(SSLSocketFactory.getDefault());
            client.connect(mqttConnectOptions);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("\n **************** \n");
                    System.out.println("MQTT LOST CONNECTION");
                    System.out.println("\n **************** \n");
                }

                @Override
                public void messageArrived(String topic, MqttMessage mqttMessage) {
                    System.out.println("MESSAGE RECEIVED");
                    System.out.println("\n **************** \n");
                    System.out.println(topic);
                    System.out.println("\n **************** \n");

                    if (topic.equals("test")) {
                        System.out.println("Topic " + topic + " well received");
                        System.out.println("Message " + mqttMessage);
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                    System.out.println("\n **************** \n");
                    System.out.println("delivery complete " + iMqttDeliveryToken);
                }
            });

            client.subscribe("test");
        }
        catch (MqttException e) {
            System.out.println(e.getMessage());
        }
    }
}
