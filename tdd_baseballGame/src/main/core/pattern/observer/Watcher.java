package main.core.pattern.observer;

import java.util.Observable;

import main.core.bean.RecordBoard;

public class Watcher extends Observable {

	public void action(RecordBoard record) {
		setChanged();
		notifyObservers(record);
	}
}
