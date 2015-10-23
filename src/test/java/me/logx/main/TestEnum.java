package me.logx.main;

public enum TestEnum {
	RED("red", "128,0,0"), BLUE("blue", "0,128,0");

	private String value;

	private String name;
	
	private TestEnum(String name, String value) {
		this.value = value;
		this.name = name;
	}
	
	public static void main(String[] args) {
//		System.out.println(TestEnum.RED.getName());
		for (TestEnum e : TestEnum.values()) {
			System.out.println(e.getName() + "..." + e.getValue());
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
