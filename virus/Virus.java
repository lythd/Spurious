package virus;

import java.io.File;

public class Virus {

	public File file;
	public VirusStatus stat;
	
	public Virus(File file, VirusStatus stat) {
		this.file = file;
		this.stat = stat;
	}
}
