package com.webtodo.WebToDo.Login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String GoToWelcomePage(ModelMap modelMap) {
        modelMap.put("name",getLoggedInUserName());
        return "WelcomePage";
    }
    private String getLoggedInUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}








//    private AuthenticationService authenticationService;
//
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }

//    @RequestMapping(value = "login",method = RequestMethod.POST)
//    public String WelcomePageHandler(@RequestParam String name, @RequestParam String password, ModelMap modelMap){
//        if (authenticationService.authenticate(name,password)) {
//            modelMap.put("name", name);
//            modelMap.put("password", password);
//            return "WelcomePage";
//        }
//        else {
//            modelMap.put("errorMessage","Invalid Credentials! Please Login Again.");
//            return "LoginPage";
//        }
//    }