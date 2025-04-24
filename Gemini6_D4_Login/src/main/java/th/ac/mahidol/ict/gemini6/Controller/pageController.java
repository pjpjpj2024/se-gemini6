package th.ac.mahidol.ict.gemini6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import th.ac.mahidol.ict.gemini6.Model.User;
import th.ac.mahidol.ict.gemini6.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import th.ac.mahidol.ict.gemini6.Model.SciencePlan;


@Controller
public class pageController {

    @Autowired
    private UserRepository userRepository;

    // === LOGIN FLOW ===

    // Show login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // login.html
    }

    // Show login error page
    @GetMapping("/login-error")
    public String loginError() {
        return "login-error";  // login-error.html
    }

    // Handle login submission
    @PostMapping("/login")
    public String login(
            HttpSession session,
            Model model,
            @RequestParam String username,
            @RequestParam String password
    ) {
        for (User user : userRepository.findAll()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                session.setAttribute("username", user.getUsername());
                session.setAttribute("name", user.getName());
                session.setAttribute("role", user.getAccessLevel());

                return "redirect:/create-science-plan";
            }
        }

        model.addAttribute("error", "Invalid username or password.");
        return "login-error";
    }

    // === PROTECTED PAGE ===

    // Show createSP page (only if logged in)
    @GetMapping("/create-science-plan")
    public String showCreateSciencePlan(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        model.addAttribute("sciencePlan", new SciencePlan());
        return "createSP";  // createSP.html
    }

//    @GetMapping("/create-science-plan")
//    public String showCreateSciencePlanPage(Model model) {
//        return "createSP";  // Render creatSP.html page for creating a science plan
//    }
//    @GetMapping("/scienceplans")
//    public String scienceplans(Model model) {
//        return "scienceplans";
//    }


//    //example
//    @GetMapping("/newpage")
//    public String anynameisok(Model model) {
//        return "nameofhtmlfile";
//    }
// link to all pages hereee

}
