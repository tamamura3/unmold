package net.unmold.beans;

import java.io.Serializable;

public class Achievement implements Serializable  {

	private int id;
	private int userId;
	private int challengeId;

	public Achievement(){}

	public Achievement(int id, int userId, int challengeId) {
		this.id = id;
		this.userId = userId;
		this.challengeId = challengeId;
	}

	public int getId() {return id;}
	public int getUserId() {return userId;}
	public int getChallengeId() {return challengeId;}

}
