package path;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

import path.PathEvent;
import path.PathListener;

public class PathPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private EventListenerList listenerList = new EventListenerList();
	
	public PathPanel() {
		Dimension size = getPreferredSize();
		size.width = 256;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Path"));
		JLabel pathLabel = new JLabel("Path: ");
		final JTextField pathField = new JTextField(10);
		JButton searchBtn = new JButton("Scan");
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firePathEvent(new PathEvent(this, pathField.getText()));
			}
		});
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 0;
		add(pathLabel, gc);
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(pathField, gc);
		
		gc.weighty = 10;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 2;
		add(searchBtn, gc);
	}
	
	public void firePathEvent(PathEvent event) {
		Object[] listeners = listenerList.getListenerList();
		for(int i = 0; i < listeners.length; i += 2) {
			if(listeners[i] == PathListener.class) {
				((PathListener) listeners[i+1]).pathEventOccured(event);
			}
		}
	}
	
	public void addPathListener(PathListener listener) {
		listenerList.add(PathListener.class, listener);
	}
	
	public void removePathListener(PathListener listener) {
		listenerList.remove(PathListener.class, listener);
	}
}
