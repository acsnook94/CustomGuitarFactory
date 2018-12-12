
/**
 * This class represents a single customer order from a factory that creates custom-built guitars
 * 
 * @author Andrew Snook
 */
public class CustOrder {
	//Order Fields
	private int orderId;
	private String custName;
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
	private String specInstr;
	private String orderStatus;
//	private CustOrder next;	//Reference to next Order in linked list
	
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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getSpecInstr() {
		return specInstr;
	}

	public void setSpecInstr(String specInstr) {
		this.specInstr = specInstr;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

//	public CustOrder getNext() {
//		return next;
//	}
//
//	public void setNext(CustOrder next) {
//		this.next = next;
//	}
	
	@Override
	public String toString() {
		return "CustOrder [orderId=" + orderId + ", custName=" + custName + ", type=" + type + ", numStrings="
				+ numStrings + ", style=" + style + ", bodyMaterial=" + bodyMaterial + ", numFrets=" + numFrets
				+ ", neckMaterial=" + neckMaterial + ", fretboardMaterial=" + fretboardMaterial + ", neckRadius="
				+ neckRadius + ", color=" + color + ", finishType=" + finishType + ", tuningPegs=" + tuningPegs
				+ ", specInstr=" + specInstr + ", orderStatus=" + orderStatus + "]";
	}
	
}
