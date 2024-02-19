package com.webtodo.WebToDo.Controller;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

//@Controller
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("list-todos")
    public String ListAllToDo(ModelMap modelMap) {
        String name = getLoggedInUserName();
        List<ToDo> todos = toDoService.findByUserName(name);
        modelMap.addAttribute("todos", todos);
        return "ListToDo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String ShowAddToDoPage(ModelMap modelMap ) {
        ToDo todo = new ToDo(1, "Adnan","", LocalDate.now(), false);
        modelMap.addAttribute("todo", todo);
        return "AddToDo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String AddNewToDo(ModelMap modelMap, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "AddToDo";
        }
        String name = getLoggedInUserName();
        ToDoService.AddToDo(name,todo.getDescription(), todo.getTargetDate(),false);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String DeleteToDo(@RequestParam int id) {
        ToDoService.DeleteToDoById(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String ShowUpdateToDoPage(@RequestParam int id, ModelMap modelMap) {
        ToDo todo = ToDoService.FindToDoById(id);
        modelMap.addAttribute("todo", todo);
        return "AddToDo";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String UpdateToDo(ModelMap modelMap, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "AddToDo";
        }
        String name = (String) modelMap.get("name");
        todo.setUserName(name);
        ToDoService.UpdateToDo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}


