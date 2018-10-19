package file;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import data.Antivirus;
import data.TFBoot;

public class FilePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private static File file;
	private JTextArea textArea;
	
	public FilePanel() {
		Dimension size = getPreferredSize();
		size.width = 256;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("File"));
		textArea = new JTextArea();
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				file.delete();
				TFBoot.go();
			}
		});
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.anchor = GridBagConstraints.NORTH;
		gc.weightx = 0;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 0;
		add(textArea, gc);
		
		gc.anchor = GridBagConstraints.SOUTH;
		gc.weightx = 0;
		gc.weighty = 5;
		gc.gridx = 0;
		gc.gridy = 1;
		add(deleteBtn, gc);
	}
	
	public void giveFile(String path) {
		file = new File(path);
		Antivirus.listFilesForFolder(file);
		textArea.setText(TFBoot.sum);
	}
}
