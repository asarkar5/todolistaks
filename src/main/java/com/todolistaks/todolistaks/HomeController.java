package com.todolistaks.todolistaks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    ToDoListRepository toDoListRepository;
    @RequestMapping("/")
    public String listCourse(Model model){
        model.addAttribute("todolists", toDoListRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String courseForm(Model model){
        model.addAttribute("todolist", new ToDoList());
        return "courseform";
    }
    @PostMapping("/process")
    public String processForm(@Valid ToDoList todolist, BindingResult result){
        if (result.hasErrors()){
            return "courseform";
        }
        toDoListRepository.save(todolist);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("todolist", toDoListRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("todolist", toDoListRepository.findById(id).get());
        return "courseform";
    }
    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        toDoListRepository.deleteById(id);
        return "redirect:/";
    }

}
