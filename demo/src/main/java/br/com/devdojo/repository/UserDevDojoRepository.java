package br.com.devdojo.repository;

import br.com.devdojo.model.UserDevDojo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDevDojoRepository extends PagingAndSortingRepository<UserDevDojo, Long> {
    UserDevDojo findByUserName(String username);
}
