package com.kodonho;

public abstract class Room {

	public void openDoor(){
		System.out.print("문을 열었습니다.");
	}
	
	public abstract void openWindow();
}
