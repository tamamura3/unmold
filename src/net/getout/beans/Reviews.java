package net.getout.beans;

import java.io.Serializable;

public class Reviews implements Serializable {

	private int id;
	private int challengeId;
	private int reviewerId;
	private String reviewText;
	private String reviewer;

	Reviews(){}

	public Reviews (int id, String reviewText) {
		this.id = id;
		this.reviewText = reviewText;
	}

	public Reviews (int id,int challengeId, int reviewerId, String reviewText, String reviewer) {
		this.id = id;
		this.challengeId = challengeId;
		this.reviewerId = reviewerId;
		this.reviewText = reviewText;
		this.reviewer = reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public int getId() {return id;}
	public int getChallengeId() {return challengeId;}
	public int getReviewerId() {return reviewerId;}
	public String getText() {return reviewText;}
	public String getReviewer() {return reviewer;}


}
