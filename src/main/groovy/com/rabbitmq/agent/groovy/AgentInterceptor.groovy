/**
 * 
 */
package com.rabbitmq.agent.groovy

import groovy.lang.Interceptor

/**
 * @author fgutierrezcru
 *
 */
class AgentInterceptor implements Interceptor {

	
	Object beforeInvoke(Object object, String methodName,
			Object[] arguments) {
		println "  BEFORE $object .$methodName $arguments"
		if( methodName == 'sayHello' ) arguments[0] += ' and family'
		return null;
	}

	
	public Object afterInvoke(Object object, String methodName,
			Object[] arguments, Object result) {
		println "  AFTER $object .$methodName $arguments: $result"
		result
	}

	
	boolean doInvoke() {
		return true;
	}

}
