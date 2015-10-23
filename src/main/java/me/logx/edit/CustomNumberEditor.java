package me.logx.edit;

import java.beans.PropertyEditorSupport;

public class CustomNumberEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.equals("")) {
			text = "0";
		}
		setValue(Integer.parseInt(text) + 10000);
	}

	@Override
	public String getAsText() {
		return getValue().toString();
	}
}
