package me.logx.propertyeditor;

import java.beans.PropertyEditorSupport;

public class TitlePositionEditor extends PropertyEditorSupport {
	
	private String[] options = { "Left", "Center", "Right" };

	public String[] getTags() {
		return options;
	}
	
	public String getJavaInitializationString() {
		return "" + getValue();
	}
	
	@Override
	public String getAsText() {
		int value = (Integer)getValue();
		return options[value];
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		super.setAsText(text);
	}
}
