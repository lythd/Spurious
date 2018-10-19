package path;

import java.util.EventListener;

import path.PathEvent;

public interface PathListener extends EventListener {
	public void pathEventOccured(PathEvent event);

}
