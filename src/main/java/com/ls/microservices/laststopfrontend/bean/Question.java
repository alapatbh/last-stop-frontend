package com.ls.microservices.laststopfrontend.bean;

public class Question {
	
	private int questionId;
	private int topicId;
	private String question;
	private char isPublic;
	private char enable;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public char getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(char isPublic) {
		this.isPublic = isPublic;
	}

	public char getEnable() {
		return enable;
	}

	public void setEnable(char enable) {
		this.enable = enable;
	}

}
