package io.javabrains.springBootDemo.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();							
	}
	
	@GetMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	@PostMapping("/topics")
	public void addNewTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
	}
	
//	@RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
	@PutMapping("/topics/{id}")
	public void updateTopic(@RequestBody Topic topic , @PathVariable String id) {
		topicService.updateTopic(id , topic);
		
	}
	
	@DeleteMapping("/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
