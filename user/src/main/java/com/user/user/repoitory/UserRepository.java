package com.user.user.repoitory;

import com.user.user.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {

    AppUser findUserByUsername(String username);
}
