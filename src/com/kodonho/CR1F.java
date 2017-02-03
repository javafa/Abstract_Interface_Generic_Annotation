package com.kodonho;

public class CR1F implements HeaterInterface, LightInterface {

	@Override
	public void onLight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void offLight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onHeater() {
		System.out.println("히터가 켜졌습니다.");
	}

	@Override
	public void offHeater() {
		// TODO Auto-generated method stub

	}

}
