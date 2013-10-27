package by.bsuir.ppvis.calculator.utls;

public enum CenterOperEnum implements EnumBtnInterface{
	ONE("1"),
	TWO("2"),
	THREE("3"),
	DIV("/"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	MULT("*"),
	SAVEN("7"),
	EIGHT("8"),
	NINE("9"),
	MINUS("-");
		
	private String label;
	private CenterOperEnum(String label){
		this.label = label;
	}
	public String getLabel(){
		return label;
	}
}
