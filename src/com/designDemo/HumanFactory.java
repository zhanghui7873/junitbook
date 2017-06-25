package com.designDemo;

public class HumanFactory extends AbstractHumanFactory {

	@Override
	public <T extends Human> T createHuman(Class<T> C) {
		Human human=null;
		try {
			human=(T)Class.forName(C.getName()).newInstance();
		} catch (InstantiationException e) {
			System.out.println("create human exceptions");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (T)human;
	}

}
