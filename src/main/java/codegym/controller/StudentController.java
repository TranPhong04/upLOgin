package codegym.controller;

import codegym.model.ClassRoom;
import codegym.model.Student;
import codegym.service.ClassService;
import codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.ServerError;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show");
        modelAndView.addObject("student",studentService.getAll());
        return modelAndView;
    }
    @ModelAttribute(name = "class")
    public List<ClassRoom> showClassrooms() {
        return classService.getAll();
    }




    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView showEdit(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("student", studentService.findByid(id));
        return modelAndView;
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView updateStudent(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        studentService.save(student);
        return modelAndView;
    }


    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create");
        return modelAndView;
    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView createStudent(@ModelAttribute Student student){
      ModelAndView  modelAndView = new ModelAndView("redirect:/");
      studentService.save(student);
      return modelAndView;
    }
}
