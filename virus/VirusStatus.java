package virus;

public class VirusStatus {

	public boolean shutdownI;
	public boolean shutdownII;
	public boolean startupI;
	public boolean startupII;
	public boolean wormI;
	public boolean wormII;
	public int danger;
	
	public VirusStatus() {
		shutdownI = false;
		shutdownII = false;
		startupI = false;
		startupII = false;
		wormI = false;
		wormII = false;
	}
	
	public void shutdownI() {
		shutdownI = true;
		danger += 4;
	}
	
	public void shutdownII() {
		shutdownII = true;
		danger += 4;
	}
	
	public void startupI() {
		startupI = true;
		danger += 3;
	}
	
	public void startupII() {
		startupII = true;
		danger += 3;
	}
	
	public void wormI() {
		wormI = true;
		danger += 1;
	}
	
	public void wormII() {
		wormII = true;
		danger += 1;
	}

	public boolean isShutdownI() {
		return shutdownI;
	}

	public boolean isShutdownII() {
		return shutdownII;
	}

	public boolean isStartupI() {
		return startupI;
	}

	public boolean isStartupII() {
		return startupII;
	}

	public boolean isWormI() {
		return wormI;
	}

	public boolean isWormII() {
		return wormII;
	}

	public int getDanger() {
		return danger;
	}
}
