package com.ls.microservices.laststopfrontend.bean;


public class Chapter {
	private int chapterId;
	private String chapterName;
	private int courseId;
	
	public Chapter() {}
	public Chapter(String chapterName, int courseId) {
		this.chapterName=chapterName;
		this.courseId=courseId;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
}
