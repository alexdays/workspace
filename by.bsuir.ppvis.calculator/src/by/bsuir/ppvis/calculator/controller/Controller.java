package by.bsuir.ppvis.calculator.controller;

import java.awt.event.ActionListener;

import by.bsuir.ppvis.calculator.utls.AdditionalOperEnum;
import by.bsuir.ppvis.calculator.utls.BottomOperEnum;
import by.bsuir.ppvis.calculator.utls.CenterOperEnum;
import by.bsuir.ppvis.calculator.utls.ChildMenus;
import by.bsuir.ppvis.calculator.utls.EnumBtnInterface;
import by.bsuir.ppvis.calculator.utls.TopOperEnum;
import by.bsuir.ppvis.calculator.view.CalcFrame;

public class Controller {
	private CalcFrame calcFrame;
	public Controller(CalcFrame calcFrame){
		this.calcFrame = calcFrame;
	}
	public ActionListener getListener(TopOperEnum i){
		switch(i){
		case LBRACKET:{
			return new LBracketBtnEvent(calcFrame);
		}
		case RBRACKET:{
			return new RBracketBtnEvent(calcFrame);
		}
		case PROCENT:{
			return new ProcentBtnEvent(calcFrame);
		}
		case ONEDIVX:{
			return new OneDivXBtnEvent(calcFrame);
		}
		case SQRT:{
			return new SQRTBtnEvent(calcFrame);
		}
		}
		return null;
	}
	public ActionListener getListener(CenterOperEnum i){
		switch(i){
		case DIV:{
			return new DivBtnEvent(calcFrame);
		}
		case MINUS:{
			return new MinusBtnEvent(calcFrame);
		}
		case MULT:{
			return new MultiplyBtnEvent(calcFrame);
		}
		case EIGHT:{
			return new EightBtnEvent(calcFrame);
		}
		case FIVE:{
			return new FiveBtnEvent(calcFrame);
		}
		case FOUR:{
			return new FourBtnEvent(calcFrame);
		}
		case NINE:{
			return new NineBtnEvent(calcFrame);
		}
		case ONE:{
			return new OneBtnEvent(calcFrame);
		}
		case SAVEN:{
			return new SevenBtnEvent(calcFrame);
		}
		case SIX:{
			return new SixBtnEvent(calcFrame);
		}
		case THREE:{
			return new ThreeBtnEvent(calcFrame);
		}
		case TWO:{
			return new TwoBtnEvent(calcFrame);
		}
		}
		return null;
	}
	public ActionListener getListener(BottomOperEnum i){
		switch(i){
		case EQUAL:{
			return new EqualBtnEvent(calcFrame);
		}
		case PLUS:{
			return new PlusBtnEvent(calcFrame);
		}
		case DOT:{
			return new DotBtnEvent(calcFrame);
		}
		case CLEARP:{
			return new ClearPBtnEvent(calcFrame);
		}
		case ZERO:{
			return new ZeroBtnEvent(calcFrame);
		}
		}
		return null;
	}
	public ActionListener getListener(AdditionalOperEnum i){
		switch(i){
		case POWX2:{
			return new PowX2BtnEvent(calcFrame);
		}
		case POWX3:{
			return new PowX3BtnEvent(calcFrame);
		}
		case POWXY:{
			return new PowXYBtnEvent(calcFrame);
		}
		}
		return null;
	}
	public ActionListener getListener(ChildMenus i){
		switch(i){
		case EXIT:{
			return new ExitMenuEvent(calcFrame);
		}
		case ABOUT:{
			return new AboutMenuEvent(calcFrame);
		}
		case CLEAR:{
			return new ClearMenuEvent(calcFrame);
		}
		case DEFAULT:{
			return new DefaultMenuEvent(calcFrame);
		}
		case INGENER:{
			return new IngenerMenuEvent(calcFrame);
		}
		}
		return null;
	}
}
