package tnm082.challenge;

public class Mission {
	/**
	 * Kodad av: Magnus S/Markus O
	 * Task nr:4
	 * Datum: 2012-03-22
	 * Estimerad tid: 4h
	 * Faktisk tid: xh
	 * Testad/av: Ja/Nej / namn
	 * Utcheckad/av: Ja/Nej / namn
	 * @param namn - beskrivning.
	 * @return namn - beskrivning.

	 */
	
	private String name;
	private String desc;
	
	public String getName() {
		name = "uberuppdraget";
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		desc = "sjukt j�vla sv�rt uppdrag";
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
