package dicdic.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value="/user")
public class UserController {


    @Autowired
    UserDetailsManager userDetailsManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @ResponseBody
    @RequestMapping(value="/", method= RequestMethod.POST)
    public String createUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password)
    {
        // TODO implementation is needed.


        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        User userDetails = new User("user", passwordEncoder.encode("password"), authorities);
        userDetailsManager.createUser(userDetails);

        userDetails = new User("admin", passwordEncoder.encode("password"), authorities);
        userDetailsManager.createUser(userDetails);

        return "success";
    }

    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String changePassword(
            @RequestParam("username") String username,
            @RequestParam("password") String password)
    {
        // TODO implementation is needed.
        return null;
    }


    @RequestMapping(value="/", method= RequestMethod.DELETE)
    public String deleteUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password)
    {
        // TODO implementation is needed.
        return null;
    }


    @RequestMapping(value="/enabled/{enabled}", method= RequestMethod.PUT)
    public String deleteUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @PathVariable("enabled")  int    enabled  )
    {
        // TODO implementation is needed.
        return null;
    }

}
