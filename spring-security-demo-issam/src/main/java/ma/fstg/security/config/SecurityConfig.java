package ma.fstg.security.config;

// Issam : Imports Spring Security
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Issam : Configuration de sécurité pour l'application
 * Auteur : Issam ABOUSSAKKINE
 * Date : 28 Mars 2026
 */
@Configuration
public class SecurityConfig {

    /**
     * Issam : Service de gestion des utilisateurs en mémoire
     * Crée trois utilisateurs avec des rôles différents
     */
    @Bean
    public UserDetailsService userDetailsService() {

        // Issam : Utilisateur ADMIN
        UserDetails admin = User.withUsername("issam_admin")
                .password("{noop}issam123")
                .roles("ADMIN")
                .build();

        // Issam : Utilisateur USER
        UserDetails user = User.withUsername("issam_user")
                .password("{noop}issam123")
                .roles("USER")
                .build();

        // Issam : Utilisateur MANAGER
        UserDetails manager = User.withUsername("issam_manager")
                .password("{noop}issam123")
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(admin, user, manager);
    }

    /**
     * Issam : Configuration des règles de sécurité
     * Définit les accès selon les rôles
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Issam : Configuration des autorisations
                .authorizeHttpRequests(auth -> auth
                        // Issam : /user/** accessible aux rôles USER et ADMIN
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                        // Issam : /admin/** accessible uniquement au rôle ADMIN
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        // Issam : /manager/** accessible uniquement au rôle MANAGER
                        .requestMatchers("/manager/**").hasRole("MANAGER")
                        // Issam : Toute autre requête nécessite une authentification
                        .anyRequest().authenticated()
                )
                // Issam : Configuration du formulaire de connexion
                .formLogin(form -> form
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                // Issam : Configuration de la déconnexion
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}