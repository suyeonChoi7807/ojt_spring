package com.company.couplingtest;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{
	
	//생성자
	public LgTV() {
		System.out.println("==========>LgTV");
	}
	
	@Override	//재정의
	public void powerOn() {
		System.out.println("LgTV ===> 전원 켠다.");
		
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV ===> 전원 끈다.");
		
	}
	
	@Override
	public void volumnUp() {
		System.out.println("LgTV ===> 볼륨 올린다.");
	}
	
	@Override
	public void volumnDown() {
		System.out.println("LgTV ===> 볼륨 내린다.");		
	}	
}
