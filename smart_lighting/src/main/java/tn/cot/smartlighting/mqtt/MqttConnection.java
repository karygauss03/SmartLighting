package tn.cot.smartlighting.mqtt;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import tn.cot.smartlighting.repositories.LightingModuleRepository;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

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


}
