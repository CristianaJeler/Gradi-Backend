package com.gradi.app.authentication.jwt;

import com.gradi.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return MyUserDetails.getDetails(userRepository.findByUsername(username));
    }

    public UserDetails getUserByID(String id){
        var res=userRepository.findById(id);;
        return res.map(MyUserDetails::getDetails).orElse(null);
    }
}
