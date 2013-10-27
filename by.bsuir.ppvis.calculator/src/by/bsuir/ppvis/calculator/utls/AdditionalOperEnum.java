package by.bsuir.ppvis.calculator.utls;

public enum AdditionalOperEnum {
	//EXP("e^x"),
	POWXY("x^y"),
	POWX2("x^2"),
	POWX3("x^3");
	
	private String label;
	private AdditionalOperEnum(String label){
		this.label = label;		
	}
		
	public String getLabel(){
		return label;
	}
}
