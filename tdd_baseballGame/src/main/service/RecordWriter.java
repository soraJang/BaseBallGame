package main.service;

import java.util.Observable;
import java.util.Observer;

import main.core.bean.RecordBoard;
import main.core.pattern.observer.Watcher;

public class RecordWriter implements Observer {

	private RecordBoard record;

	public RecordWriter(RecordBoard record) {
		this.record = record;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Watcher) {
			System.out.println("recordWriter!!");
		}
	}
}
