package com.amit.core.designpattern.g.prototype;

public class Client01 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Game game1 = new Game();
		game1.setId(101);
		game1.setName("TempleRun");
		game1.setMembership(new MemberShip());
		
		Game game2 = game1.clone();
		System.out.println(game1.hashCode());
		System.out.println(game2.hashCode());
		System.out.println(game1);
		System.out.println(game2);
		
		Game game3 = new Game(game1);
		System.out.println(game3);
	}
}
/*
One player want to play TempleRun and other player has come and he also wants to play the same game.
Instead of instantiating from scratch using the new operator, We will create other instance which
is equal to the earlier one using the clone method.
But here hashcode of both the object will be different.

*/