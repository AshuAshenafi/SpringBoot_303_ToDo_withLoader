package com.example.demo;

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
    ToDoRepository todoRepository;

    @RequestMapping("/")
    public String listToDo(Model model){
//        model.addAttribute("byPriority", )
        model.addAttribute("todos", todoRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String loadToDo(Model model){
        model.addAttribute("toDo", new ToDo());
        return "todoform";
    }

    @PostMapping("/process")
    public String processForm(@Valid ToDo toDo, BindingResult result){
        if(result.hasErrors()){
            return "todoform";
        }
        todoRepository.save(toDo);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updateToDo(@PathVariable("id") long id, Model model){
        model.addAttribute("toDo", todoRepository.findById(id).get());
        return "todoform";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("toDo", todoRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        todoRepository.deleteById(id);
        return "redirect:/";
    }

}
