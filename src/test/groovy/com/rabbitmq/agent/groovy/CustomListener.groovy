/**
 * 
 */
package com.rabbitmq.agent.groovy

import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageListener;

/**
 * @author fgutierrezcru
 *
 */
class CustomListener implements MessageListener {
	
	void onMessage(Message message) {
		println message
	}

}
