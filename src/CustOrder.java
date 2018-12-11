
/**
 * This class represents a single customer order from a factory that creates custom-built guitars
 * 
 * @author Andrew Snook
 */
public class CustOrder {
	
	//Order Fields
	private String type;
	private int numStrings;
	private String style;
	private String bodyMaterial;
	private int numFrets;
	private String neckMaterial;
	private String fretboardMaterial;
	private String neckRadius;
	private String color;
	private String finishType;
	private String tuningPegs;
	private CustOrder next;	//Reference to next Order in linked list
	
	//Constructor
	public CustOrder() {
	}

	//Getters & Setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumStrings() {
		return numStrings;
	}

	public void setNumStrings(int numStrings) {
		this.numStrings = numStrings;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getBodyMaterial() {
		return bodyMaterial;
	}

	public void setBodyMaterial(String bodyMaterial) {
		this.bodyMaterial = bodyMaterial;
	}

	public int getNumFrets() {
		return numFrets;
	}

	public void setNumFrets(int numFrets) {
		this.numFrets = numFrets;
	}

	public String getNeckMaterial() {
		return neckMaterial;
	}

	public void setNeckMaterial(String neckMaterial) {
		this.neckMaterial = neckMaterial;
	}

	public String getFretboardMaterial() {
		return fretboardMaterial;
	}

	public void setFretboardMaterial(String fretboardMaterial) {
		this.fretboardMaterial = fretboardMaterial;
	}

	public String getNeckRadius() {
		return neckRadius;
	}

	public void setNeckRadius(String neckRadius) {
		this.neckRadius = neckRadius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFinishType() {
		return finishType;
	}

	public void setFinishType(String finishType) {
		this.finishType = finishType;
	}

	public String getTuningPegs() {
		return tuningPegs;
	}

	public void setTuningPegs(String tuningPegs) {
		this.tuningPegs = tuningPegs;
	}

	public CustOrder getNext() {
		return next;
	}

	public void setNext(CustOrder next) {
		this.next = next;
	}
	
}
