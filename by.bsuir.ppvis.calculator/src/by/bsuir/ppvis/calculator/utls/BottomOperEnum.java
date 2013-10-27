package by.bsuir.ppvis.calculator.utls;

public enum BottomOperEnum implements EnumBtnInterface {
	ZERO("0"),
	CLEARP("C"),
	DOT("."),
	EQUAL("="),
	PLUS("+");
	
	private String label;
	private BottomOperEnum(String label){
		this.label = label;
	}
	public String getLabel(){
		return label;
	}
}
