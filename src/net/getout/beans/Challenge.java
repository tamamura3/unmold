package net.getout.beans;

import java.io.Serializable;

public class Challenge implements Serializable {

	private int challengeId;
	private String challengeName;
	private String description;

	public Challenge(){}

	public Challenge(int challengeId, String challengeName, String discription) {
		this.challengeId = challengeId;
		this.challengeName = challengeName;
		this.description = discription;
	}

	public void setChallenge(int challengeId, String challengeName, String discription) {
		this.challengeId = challengeId;
		this.challengeName = challengeName;
		this.description = discription;
	}

	public int getChallengeId() {return challengeId;}
	public String getChallengeName() {return challengeName;}
	public String getDescription() {return description;}

}
