package ma.fstg.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Auteur : Issam ABOUSSAKKINE
@Controller
public class HomeController {

    // Page d'accueil - redirige vers accueil.html
    @GetMapping("/")
    public String home() {
        return "accueil";
    }

    // Page d'accueil apres connexion
    @GetMapping("/accueil")
    public String accueil() {
        return "accueil";
    }

    // Page de connexion personnalisee
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Espace USER - accessible aux roles USER et ADMIN
    @GetMapping("/user/espace")
    public String userEspace() {
        return "user_espace";
    }

    // Espace ADMIN - accessible uniquement au role ADMIN
    @GetMapping("/admin/espace")
    public String adminEspace() {
        return "admin_espace";
    }

    // Espace MANAGER - accessible uniquement au role MANAGER
    @GetMapping("/manager/espace")
    public String managerEspace() {
        return "manager_espace";
    }
}