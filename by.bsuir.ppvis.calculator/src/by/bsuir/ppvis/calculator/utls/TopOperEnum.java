package by.bsuir.ppvis.calculator.utls;

public enum TopOperEnum implements EnumBtnInterface {
	SQRT("sqrt"),
	PROCENT("%"),
	LBRACKET("("),
	RBRACKET(")"),
	ONEDIVX("1/x");
	
	private String label;
	private TopOperEnum(String label){
		this.label = label;
	}
	public String getLabel(){
		return label;
	}
}
