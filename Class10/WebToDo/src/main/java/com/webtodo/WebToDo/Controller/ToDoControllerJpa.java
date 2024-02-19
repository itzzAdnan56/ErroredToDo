package com.webtodo.WebToDo.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {
    @Autowired
    private ToDoRepository toDoRepository;

    @RequestMapping("list-todos")
    public String ListAllToDo(ModelMap modelMap) {
        String name = getLoggedInUserName();
        List<ToDo> todos = toDoRepository.findByUserName(name);
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
        todo.setUserName(name);
        toDoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String DeleteToDo(@RequestParam int id) {
        toDoRepository.deleteById(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String ShowUpdateToDoPage(@RequestParam int id, ModelMap modelMap) {
        ToDo todo = toDoRepository.findById(id).get();
        modelMap.addAttribute("todo", todo);
        return "AddToDo";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String UpdateToDo(ModelMap modelMap, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "AddToDo";
        }
        ToDo existingTodo = toDoRepository.findById(todo.getId()).get();
        todo.setId(existingTodo.getId());
        String name = (String) modelMap.get("name");
        todo.setUserName(name);
        toDoRepository.save(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}


