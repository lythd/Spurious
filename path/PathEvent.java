package path;

import java.util.EventObject;

public class PathEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	
	private String text;
	
	public PathEvent(Object source, String text) {
		super(source);
		
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
