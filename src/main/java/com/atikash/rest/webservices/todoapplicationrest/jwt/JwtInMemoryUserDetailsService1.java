package com.atikash.rest.webservices.todoapplicationrest.jwt;

        import com.atikash.rest.webservices.todoapplicationrest.user.User;
        import com.atikash.rest.webservices.todoapplicationrest.user.UserJpaRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService1 implements UserDetailsService {

  @Autowired
  UserJpaRepository userJpaRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User findFirst = userJpaRepository.findByUsername(username);

    if (findFirst == null) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    UserDetails userDetails = new JwtUserDetails(findFirst.getId(), findFirst.getUsername(), findFirst.getPassword(), null);
    return userDetails;

  }
}


