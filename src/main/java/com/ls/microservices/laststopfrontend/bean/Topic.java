package com.ls.microservices.laststopfrontend.bean;

public class Topic {
	
	private int topicId;
	private int chapterId;
	private String topicName;
	
	public Topic() {}
	
	public Topic(String topicName, int chapterId) {
		this.topicName=topicName;
		this.chapterId=chapterId;
	}
	
	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
}
