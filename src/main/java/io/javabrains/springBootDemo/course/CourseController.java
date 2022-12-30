package io.javabrains.springBootDemo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllTopics(@PathVariable String topicId) {
        return courseService.getAllCourses();
    }

    @GetMapping("/topics/{id}")
    public Optional<Course> getTopic(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/topics")
    public void addNewTopic(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    //	@RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
    @PutMapping("/topics/{id}")
    public void updateTopic(@RequestBody Course course, @PathVariable String id) {
        courseService.updateCourse(id, course);

    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

}
