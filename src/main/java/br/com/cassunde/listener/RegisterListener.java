package br.com.cassunde.listener;

import org.redisson.api.listener.MessageListener;

public class RegisterListener<T> {
	
	private Class<T> type;
	private MessageListener<? extends T> listenerprivate;
	public RegisterListener(Class<T> type, MessageListener<? extends T> listenerprivate) {
		super();
		this.type = type;
		this.listenerprivate = listenerprivate;
	}
	public Class<T> getType() {
		return type;
	}
	public MessageListener<? extends T> getListenerprivate() {
		return listenerprivate;
	}
}
