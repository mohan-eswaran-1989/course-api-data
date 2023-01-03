package io.javabrains.springBootDemo.course;

import io.javabrains.springBootDemo.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @GetMapping("/topics/{topicId}courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    @PostMapping("/topics/{topicId}/courses")
    public void addNewCourse(@RequestBody Course course , @PathVariable String topicId) {
        course.setTopic(new Topic(topicId," "," "));
        courseService.addCourse(course);
    }

    //	@RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
    @PutMapping("/topics/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId," "," "));
        courseService.updateCourse(course);

    }

    @DeleteMapping("/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String topicId) {
        courseService.deleteCourse(topicId);
    }

}
