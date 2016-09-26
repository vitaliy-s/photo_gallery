package ua.sosna.service.impl;

import ua.sosna.model.User;
import ua.sosna.repository.RoleRepository;
import ua.sosna.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.sosna.service.UserService;
import ua.sosna.service.modelView.UserView;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public int findByEmailExists(String mail) {
        return userRepository.findByEmailExists(mail);
    }

    @Override
    public int findByUserNameExists(String name) {
        return userRepository.findByUserNameExists(name);
    }

    @Override
    public UserView findUserNameOnView(String userName) {
        User user = userRepository.findByUsername(userName);
        return new UserView(user.getUsername(), user.getLastName(), user.getEmail(), user.getBirthday());
    }

    @Override
    public String validationUser(User user){
        if(user.getUsername().equals("") || user.getUsername().length() <= 4){
            return "Err-firstName";
        }
        if(findByUserNameExists(user.getUsername()) > 0){
            return "Err-name-exist";
        }

        if(user.getLastName().equals("") || user.getLastName().length() <= 4){
            return "Err-LastName";
        }
        if(!user.getPassword().equals(user.getPasswordConfirm()) && user.getPassword().length() > 3){
            return "Err-password";
        }
        if(validateMail(user.getEmail())){
            return "Err-mail";
        }
        if(findByEmailExists(user.getEmail()) > 0){
            return "Err-mail-exist";
        }

        save(user);
        return "success.form";
    }

    public boolean validateMail(String mail){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

}
