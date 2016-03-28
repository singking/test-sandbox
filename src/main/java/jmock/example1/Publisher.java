package jmock.example1;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

	private List<Subscriber> subscribers;

	public Publisher() {
		subscribers = new ArrayList<Subscriber>();
	}

	public void add(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	public void publish(String message) {
		for (Subscriber s : subscribers) {
			s.receive(message);
		}
	}

	public void setSubscribers(List<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}

	public List<Subscriber> getSubscribers() {
		return subscribers;
	}
}
