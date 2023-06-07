package com.javalec.bbs.function;

public enum AllergyList {
	allergy1("게"),
	allergy2("고등어"),
	allergy3("난류"),
	allergy4("닭고기"),
	allergy5("대두(콩)"),
	allergy6("돼지고기"),
	allergy7("땅콩"),
	allergy8("메밀"),
	allergy9("밀"),
	allergy10("복숭아"),
	allergy11("새우"),
	allergy12("쇠고기"),
	allergy13("어패류(굴, 전복, 홍합 포함)"),
	allergy14("오징어"),
	allergy15("우유"),
	allergy16("잣"),
	allergy17("토마토"),
	allergy18("호두")
	;
	
	
	private final String label;
	
	AllergyList(String label) {
		this.label = label;
	}
	
	public String label() {
		return label;
	}
	
}
