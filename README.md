The government is building a centralized library management system which involves a micro-service, allowing people to issue books and return them at the right time.
 
 
Library management requires creating users and renewing user subscriptions via authenticated processes. Secure create-user and renew-user-subscription APIs with Spring Security. The API issue-book should be permitted for everyone. This micro-service should be built using the Spring Boot REST API framework and it should connect to the database using the JPA API and secure methods using Spring Security.
 
 
In this task, implement three APIs for which the details are given below:
 
 
 
  /api/v1/create-user [POST]: Simple user save method in an authenticated manner
  /api/v1/issue-book [POST]: Send issue, check if users subscribed(see subscribed field in User entity), otherwise throw SubscriptionExpiredException- permitAll
/api/v1/renew-user-subscription/{id} [GET]: Send userId, set user subscription to true in an authenticated manner.
 
 
 
Your task is to complete the files given below:
 
 
src/main/java/com/wecp/library/controller/LibraryController.java
src/main/java/com/wecp/library/security/WebSecurityConfigurer.java
src/main/java/com/wecp/library/repository/UserRepository.java
src/main/java/com/wecp/library/repository/IssueRepository.java
 
 
 
You can find blank jpa repositories here:
 
 
src/main/java/com/wecp/library/repository/UserRepository.java
src/main/java/com/wecp/library/repository/IssueRepository.java
 
 
 
Notes:
 
 
Implementation related specifics are added directly as javadocs in the workspace.
Ensure that the structure and datatypes of the APIs are followed as specified in the comments to ensure that the code is evaluated correctly.
 
 
 
package com.wecp.library.controller;
 
import com.wecp.library.controller.exception.UserNotSubscribedException;
import com.wecp.library.domain.Issue;
import com.wecp.library.domain.User;
import com.wecp.library.repository.IssueRepository;
import com.wecp.library.repository.UserRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
 
import java.util.Optional;
 
/**
* REST controller for managing library system process
*/
@RestController
@RequestMapping("/api/v1")
public class LibraryController {
 
    /**
     * {@code POST  /issueBook} : Create a new issue.
     *
     * @param issue the issue to create.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     * the user, or if does not exist, return with status "noContent".
     * If user is not subscribed, throw {@link UserNotSubscribedException}
     */
 
    @Autowired
    private UserRepository userRepo;
 
    @Autowired
    private IssueRepository issueRepo;
 
    @PostMapping("/issue-book")
    public ResponseEntity<Issue> issueBook(@RequestBody Issue issue) {
        Optional<User> userOpt = userRepo.findById(issue.getUser().getId());
        if(userOpt.isPresent() && userOpt.get().getSubscribed())
        {
            Issue savedIssue = issueRepo.save(issue);
            return ResponseEntity.ok(savedIssue);
        }
        else{
            throw new UserNotSubscribedException("User subscription has expired");
        }

 
 
        
    }
 
    /**
     * {@code POST  /user} : Create a new user.
     *
     * @param user the user to create.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the new user
     */
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepo.save(user);
        return ResponseEntity.ok(savedUser);
    }
 
    /**
     * {@code GET  /renew-user-subscription/:id} :  Send userId, set user subscription to true
     *
     * @param id the id of the user to renew subscription.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     * the user, or if does not exist, return with status "noContent".
     */
    @GetMapping("renew-user-subscription/{id}")
    public ResponseEntity<User> renewUserSubscription(@PathVariable Long id) {
        Optional<User> userOpt = userRepo.findById(id);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            user.setSubscribed(true);
            userRepo.save(user);
            return ResponseEntity.ok(user);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

}
 
 
package com.wecp.library.security;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
/**
* Configure Spring Security class here. Don't forget to extend the class with the necessary Spring Security class.
* user and renew-user-subscription APIs must be authenticated and issue-book must be permitAll.
*/
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{
 
@Override
protected void configure(HttpSecurity http) throws Exception
{
    http
    .csrf().disable()
    .authorizeRequests()
    .antMatchers("/api/v1/issue-book [POST]").permitAll()
    .anyRequest().authenticated()
    .and().httpBasic(); 
}
 
@Bean
public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}
 
}
