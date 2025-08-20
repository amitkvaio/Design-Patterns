package com.amit.core.designpattern.i.doubleton;
public class DoubleTon
{
	private static DoubleTon[] tons = new DoubleTon[2];
	
	private static int index;
	
	private DoubleTon()
	{
		System.out.println("DoubleTon()");
	}
	
	static 
	{
		tons[0]= new DoubleTon();
		tons[1]= new DoubleTon();
	}
	
	public static DoubleTon getObject()
	{
		return tons[(index++) % 2];
	}
	
	public static void main(String[] args)
	{
		DoubleTon d1 = DoubleTon.getObject();
		DoubleTon d2 = DoubleTon.getObject();
		DoubleTon d3 = DoubleTon.getObject();
		DoubleTon d4 = DoubleTon.getObject();
		DoubleTon d5 = DoubleTon.getObject();
		DoubleTon d6 = DoubleTon.getObject();
		DoubleTon d7 = DoubleTon.getObject();
		DoubleTon d8 = DoubleTon.getObject();
		DoubleTon d9 = DoubleTon.getObject();
		
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);
		System.out.println(d5);
		System.out.println(d6);
		System.out.println(d7);
		System.out.println(d8);
		System.out.println(d9);
	}
}
