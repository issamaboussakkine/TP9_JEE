package ma.fstg.security.web;

// Issam : Imports Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Issam : Contrôleur principal pour la gestion des pages
 * Auteur : Issam ABOUSSAKKINE
 * Date : 28 Mars 2026
 */
@Controller
public class HomeController {

    /**
     * Issam : Page d'accueil - Redirection vers accueil.html
     * URL : /
     */
    @GetMapping("/")
    public String home() {
        return "accueil";
    }

    /**
     * Issam : Page d'accueil après connexion
     * URL : /accueil
     */
    @GetMapping("/accueil")
    public String accueil() {
        return "accueil";
    }

    /**
     * Issam : Page de connexion personnalisée
     * URL : /login
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Issam : Espace USER - accessible aux rôles USER et ADMIN
     * URL : /user/espace
     */
    @GetMapping("/user/espace")
    public String userEspace() {
        return "user_espace";
    }

    /**
     * Issam : Espace ADMIN - accessible uniquement au rôle ADMIN
     * URL : /admin/espace
     */
    @GetMapping("/admin/espace")
    public String adminEspace() {
        return "admin_espace";
    }

    /**
     * Issam : Espace MANAGER - accessible uniquement au rôle MANAGER
     * URL : /manager/espace
     */
    @GetMapping("/manager/espace")
    public String managerEspace() {
        return "manager_espace";
    }
}