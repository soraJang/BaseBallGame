package test.designPattern.observer;

import main.core.bean.RecordBoard;
import main.core.pattern.observer.Watcher;
import main.service.RecordWriter;

import org.junit.Test;

public class WatcherTest {

	@Test
	public void watcherTest() {
		Watcher watcher = new Watcher();
//		CompareNum checkNum = new CompareNum(new RecordBoard());
		RecordBoard board = new RecordBoard();
		board.setGameCount(5);
		RecordWriter writer = new RecordWriter(board);

		watcher.addObserver(writer);
		watcher.hasChanged();

		watcher.action(board);
	}
}
