package data;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import virus.Virus;

public class TFBoot{

	public static String sum;
	private static Virus v;
	private static boolean go = true;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MainFrame("Spurious Anti-Virus");
				frame.setSize(512,  384);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);				
			}
		});
	}
	
	public static void bat(Virus virus) {
		v = virus;
		go = false;
		sum = v.file.getName() + "'s Summary:";
		if(v.stat.shutdownI) sum += "\n Infected with malware.Shutdown\n Accuracy: 99%";
		if(v.stat.shutdownII) sum += "\n Infected with malware.Shutdown\n Accuracy: 90%";
		if(v.stat.startupI) sum += "\n Infected with malware.Worm.Startup\n Accuracy: 99%";
		if(v.stat.startupII) sum += "\n Infected with malware.Worm.Startup\n Accuracy: 75%";
		if(v.stat.wormI) sum += "\n Infected with malware.Worm\n Accuracy: 99%";
		if(v.stat.wormII) sum += "\n Infected with malware.Worm\n Accuracy: 75%";
		if(v.stat.danger  < 1) sum += "\nDanger: " + v.stat.danger + "\nStatus: Clean";
		if(v.stat.danger  < 3) sum += "\nDanger: " + v.stat.danger + "\nStatus: Low";
		if(v.stat.danger  < 5) sum += "\nDanger: " + v.stat.danger + "\nStatus: Medium";
		if(v.stat.danger  < 10) sum += "\nDanger: " + v.stat.danger + "\nStatus: High";
		if(v.stat.danger  < 25) sum += "\nDanger: " + v.stat.danger + "\nStatus: Severe";
	}
	
	public static boolean getGo() {
		return go;
	}
	
	public static void go() {
		go = true;
	}
}
