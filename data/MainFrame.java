package data;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import file.FilePanel;
import path.PathEvent;
import path.PathListener;
import path.PathPanel;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private PathPanel pathPanel;
	private FilePanel filePanel;
	
	public MainFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		filePanel = new FilePanel();
		pathPanel = new PathPanel();
		
		pathPanel.addPathListener(new PathListener() {
			public void pathEventOccured(PathEvent event) {
				filePanel.giveFile(event.getText());
			}
		});
		Container c = getContentPane();
		c.add(filePanel, BorderLayout.EAST);
		c.add(pathPanel, BorderLayout.WEST);
	}
}
