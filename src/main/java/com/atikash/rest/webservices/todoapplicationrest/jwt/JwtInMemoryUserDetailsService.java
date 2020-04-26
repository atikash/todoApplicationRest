package com.atikash.rest.webservices.todoapplicationrest.jwt;

import com.atikash.rest.webservices.todoapplicationrest.user.User;
import com.atikash.rest.webservices.todoapplicationrest.user.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//
//@Service
//public class JwtInMemoryUserDetailsService implements UserDetailsService {
//
//  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
//
//  static {
//    inMemoryUserList.add(new JwtUserDetails(1L, "atikash",
//        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
//    inMemoryUserList.add(new JwtUserDetails(1L, "atikashSingh",
//            "$2a$10$7m6dnF8XuOnwG4MpxZOdSenLQpk06pdCgVaRCpgmtrbmJIOwv9W1u", "ROLE_USER_2"));
//  }
//
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
//        .filter(user -> user.getUsername().equals(username)).findFirst();
//
//    if (!findFirst.isPresent()) {
//      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
//    }
//
//    return findFirst.get();
//  }
//
//}



@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  UserJpaRepository userJpaRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User findFirst = userJpaRepository.findByUsername(username);

    if (findFirst == null) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    UserDetails userDetails = new JwtUserDetails(findFirst.getId(), findFirst.getUsername(), new BCryptPasswordEncoder().encode(findFirst.getPassword()), "user");
    return userDetails;

  }
}


