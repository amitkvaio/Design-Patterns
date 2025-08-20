package com.amit.core.designpattern.g.prototype;

public class Game implements Cloneable {
	private int id;
	private String name;
	private MemberShip membership;

	/*
	//Case One
	@Override
	protected Game clone() throws CloneNotSupportedException {
		return (Game) super.clone();
	}
	
	*/
	

	/* 
	 CASE TWO
	*/
	
	@Override
	protected Game clone() throws CloneNotSupportedException {
		Game game = (Game) super.clone();
		game.setMembership(new MemberShip());
		return game;
	}
	
	
	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	//copy-constructor
	public Game(Game game) {
		this.id = game.id;
		this.name =game.name;
		this.membership = new MemberShip();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMembership(MemberShip membership) {
		this.membership = membership;
	}

	public MemberShip getMembership() {
		return membership;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", membership=" + membership + "]";
	}

}
