package example61_computerData;

public class ComputerItem {

	String processorType = null; // 處理器種類

	String processorSpeed = null; // 處理器速度

	Double processorSize = 0.0; // 螢幕尺寸

	String weight = null; // 重量

	String RAM = null; // 內建記憶體

	public String getProcessorType() {
		return processorType;
	}

	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}

	public String getProcessorSpeed() {
		return processorSpeed;
	}

	public void setProcessorSpeed(String processorSpeed) {
		this.processorSpeed = processorSpeed;
	}

	public Double getProcessorSize() {
		return processorSize;
	}

	public void setProcessorSize(Double processorSize) {
		this.processorSize = processorSize;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getRAM() {
		return RAM;
	}

	public void setRAM(String rAM) {
		RAM = rAM;
	}

}
