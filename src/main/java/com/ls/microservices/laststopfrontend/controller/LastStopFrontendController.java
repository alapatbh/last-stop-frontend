package com.ls.microservices.laststopfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.ls.microservices.laststopfrontend.bean.Chapter;
import com.ls.microservices.laststopfrontend.bean.Course;
import com.ls.microservices.laststopfrontend.bean.Question;
import com.ls.microservices.laststopfrontend.bean.Topic;
import com.ls.microservices.laststopfrontend.constants.Constants;

@Controller
public class LastStopFrontendController {
	
	@Autowired
	Question ques;
	
	@RequestMapping("/home")
	public String home(Model model) {
		//System.out.println("bhanu");
		model.addAttribute("allCourses", new RestTemplate().getForObject(Constants.REST_URL+"Courses/get", Course[].class));
		return "home";
	}
	
	@RequestMapping("/course")
	public String getCourseChapters(@RequestParam("id") String id,Model model) {
		model.addAttribute("allChapters",new RestTemplate().getForObject(Constants.REST_URL+"Chapters/getByCourseId/"+id,Chapter[].class));
		model.addAttribute("courseIdInput",id);
		return "chapter";
	}
	
	@RequestMapping("/chapter")
	public String getChapterTopics(@RequestParam("id") String id,Model model) {
		model.addAttribute("chapterIdInput", id);
		model.addAttribute("allTopics",new RestTemplate().getForObject(Constants.REST_URL+"Topics/getByChapterId/"+id,Topic[].class));
		return "topic";
	}
	
	@RequestMapping("/topic")
	public String getTopicQuestions(@RequestParam("id") String id,Model model) {
		model.addAttribute("allQuestions",new RestTemplate().getForObject(Constants.REST_URL+"Questions/getByTopic/"+id,Question[].class));
		model.addAttribute("topicId", id);
		return "question";
	}
	
	@RequestMapping("/insertTopic")
	public String insertNewTopic(@RequestParam("topicName") String topicName,
			@RequestParam("chapterId") String chapterId, Model model) {
		new RestTemplate().postForObject(Constants.REST_URL+"Topics/post", 
				new Topic(topicName,Integer.parseInt(chapterId)), String.class);
		model.addAttribute("chapterIdInput", chapterId);
		model.addAttribute("allTopics",new RestTemplate().getForObject(Constants.REST_URL+"Topics/getByChapterId/"+chapterId,Topic[].class));
		return "topic";
	}
	
	@RequestMapping("/insertChapter")
	public String insertNewChapter(@RequestParam("chapterName") String chapterName,
			@RequestParam("courseId") String courseId, Model model) {
		new RestTemplate().postForObject(Constants.REST_URL+"Chapters/post", 
				new Chapter(chapterName,Integer.parseInt(courseId)), String.class);
		model.addAttribute("courseIdInput",courseId);
		model.addAttribute("allChapters",new RestTemplate().getForObject(Constants.REST_URL+"Chapters/getByCourseId/"+courseId,Chapter[].class));
		return "chapter";
	}
	
	@RequestMapping("/insertCourse")
	public String inserNewCourse(@RequestParam("courseName") String courseName, Model model) {
			new RestTemplate().postForObject(Constants.REST_URL+"Courses/post", 
				new Course(courseName), String.class);
			model.addAttribute("allCourses", new RestTemplate().getForObject(Constants.REST_URL+"Courses/get", Course[].class));
			return "home";
	}
	
	@RequestMapping("/insertQuestion")
	public String insertQuestion(@RequestParam("question") String question, Model model,
			@RequestParam("id") String id,@RequestParam("difficulty") char difficulty, @RequestParam("answer") String answer) {
		ques.setEnable('y');
		ques.setIsPublic('y');
		ques.setQuestion(question);
		ques.setTopicId(Integer.parseInt(id));
		ques.setDifficulty(difficulty);
		ques.setAnswers(answer);		
		new RestTemplate().postForObject(Constants.REST_URL+"Questions/post", ques, String.class);
	
		model.addAttribute("topicId", id);
		model.addAttribute("allQuestions",new RestTemplate().getForObject(Constants.REST_URL+"Questions/getByTopic/"+id,Question[].class));
		return "question";
	}
	
}
