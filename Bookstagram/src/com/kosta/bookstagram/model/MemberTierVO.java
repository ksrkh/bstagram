package com.kosta.bookstagram.model;

public class MemberTierVO {
	/*
	 * 회원등급
	 */
	private int tier;
	/*
	 * 회원 등급 명
	 */
	private String tier_name;
	/*
	 * 기본생성자
	 */
	public MemberTierVO() {}
	
	/**
	 * @param tier		회원등급
	 * @param tier_name	회원등급명
	 */
	public MemberTierVO(int tier, String tier_name) {
		super();
		this.tier = tier;
		this.tier_name = tier_name;
	}
	
	public int getTier() {
		return tier;
	}
	
	public void setTier(int tier) {
		this.tier = tier;
	}
	
	public String getTier_name() {
		return tier_name;
	}
	
	public void setTier_name(String tier_name) {
		this.tier_name = tier_name;
	}
	
	@Override
	public String toString() {
		return "MemberTierVO [tier=" + tier + ", tier_name=" + tier_name + "]";
	}
}
