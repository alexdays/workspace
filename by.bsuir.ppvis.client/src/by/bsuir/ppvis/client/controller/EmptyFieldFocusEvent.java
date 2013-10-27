package by.bsuir.ppvis.client.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

import by.bsuir.ppvis.client.view.InputDialog;

public class EmptyFieldFocusEvent implements FocusListener {
	public EmptyFieldFocusEvent(InputDialog id){		
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		((JTextField)arg0.getSource()).setText("");
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
		if(((JTextField)arg0.getSource()).getText().isEmpty()){
			if(((JTextField)arg0.getSource()).toString()=="inputStudentFIO"){
				((JTextField)arg0.getSource()).setText(" [ Enter student FIO ]");
			} else if(arg0.getSource()=="inputParentsFIO"){
				((JTextField)arg0.getSource()).setText(" [ Enter parent's FIO ]");
			} else if(arg0.getSource()=="inputWorkingAddress"){
				((JTextField)arg0.getSource()).setText(" [ Enter parent's working address ]");
			} else if(arg0.getSource()=="inputParentsPost"){
				((JTextField)arg0.getSource()).setText(" [ Enter parent's post ]");
			} else if(arg0.getSource()=="inputParentsExperience"){
				((JTextField)arg0.getSource()).setText(" [ Enter parent's experience ]");
			} 
		}
	}

}
