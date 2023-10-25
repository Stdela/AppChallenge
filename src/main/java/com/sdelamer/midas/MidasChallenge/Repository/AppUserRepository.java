package com.sdelamer.midas.MidasChallenge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdelamer.midas.MidasChallenge.Model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	AppUser findByEmail(String email);
}
