package br.com.devdojo.service;

import br.com.devdojo.model.UserDevDojo;
import br.com.devdojo.repository.UserDevDojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userDetailsService")
public class CostumerUserDetailService implements UserDetailsService {

    private  final UserDevDojoRepository userDevDojoRepository;
    @Autowired
    public CostumerUserDetailService(UserDevDojoRepository userDevDojoRepository) {
        this.userDevDojoRepository = userDevDojoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDevDojo userDevDojo = Optional.ofNullable(userDevDojoRepository.findByUserName(username))
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new org.springframework.security.core.userdetails.User
                (userDevDojo.getUsername(),
                        userDevDojo.getPassword(),
                        userDevDojo.isAdmin() ? authorityListAdmin:authorityListUser);

    }

    //@Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDevDojo userDevDojo = Optional.ofNullable(userDevDojoRepository.findByUserName(username))
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
//        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
//        return  new org.springframework.security.core.userdetails.User
//                (userDevDojo.getUsername(),
//                        userDevDojo.getPassword(),
//                        userDevDojo.isAdmin() ? authorityListUser:authorityListAdmin);
//    }
}
