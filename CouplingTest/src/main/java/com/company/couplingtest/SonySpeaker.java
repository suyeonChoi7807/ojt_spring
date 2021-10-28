package com.company.couplingtest;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker {
	//생성자
	public SonySpeaker() {
		System.out.println("======>SonySpeaker 객체 생성");
	}
	
	public void volumnUp() {
		System.out.println("SonySpeaker ====> 볼륨 올린다.");
	}
	
	public void volumnDown() {
		System.out.println("SonySpeaker ====> 볼륨 내린다.");
	}
}
