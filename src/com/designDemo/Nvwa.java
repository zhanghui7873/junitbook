package com.designDemo;

public class Nvwa {

	public static void main(String[] args) {
		HumanFactory hf=new HumanFactory();
		
		Human blackman=hf.createHuman(BlackHuman.class);
		blackman.getColor();
		blackman.talk();
		YellowHuman yellowman=hf.createHuman(YellowHuman.class);
		yellowman.getColor();
		yellowman.talk();
		
		WhiteHuman whiteman=hf.createHuman(WhiteHuman.class);
		whiteman.getColor();
		whiteman.talk();
		

	}

}
