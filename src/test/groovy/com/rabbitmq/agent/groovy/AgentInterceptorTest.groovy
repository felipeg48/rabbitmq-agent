/**
 * 
 */
package com.rabbitmq.agent.groovy

import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import com.rabbitmq.agent.groovy.AgentInterceptor;
import com.rabbitmq.client.ConnectionFactory

/**
 * @author fgutierrezcru
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
class AgentInterceptorTest {

	@Autowired
	def amqpTemplate
	
	@Test
	void agentInterceptor(){
		def proxy= ProxyMetaClass.getInstance(ConnectionFactory)
		proxy.interceptor= new AgentInterceptor()
		proxy.use{
		
			amqpTemplate.convertAndSend("myexchange","", "foo")

			
		}
		
	}
}
