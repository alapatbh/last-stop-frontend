package com.ls.microservices.laststopfrontend.controller;

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
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("allCourses", new RestTemplate().getForObject(Constants.REST_URL+"Courses/get", Course[].class));
		return "home";
	}
	
	@RequestMapping("/course")
	public String getCourseChapters(@RequestParam("id") String id,Model model) {
		model.addAttribute("allChapters",new RestTemplate().getForObject(Constants.REST_URL+"Chapters/get",Chapter[].class));
		return "chapter";
	}
	
	@RequestMapping("/chapter")
	public String getChapterTopics(@RequestParam("id") String id,Model model) {
		model.addAttribute("allTopics",new RestTemplate().getForObject(Constants.REST_URL+"Topics/get",Topic[].class));
		return "topic";
	}
	
	@RequestMapping("/topic")
	public String getTopicQuestions(@RequestParam("id") String id,Model model) {
		model.addAttribute("allQuestions",new RestTemplate().getForObject(Constants.REST_URL+"Questions/get",Question[].class));
		return "question";
	}
	
}
