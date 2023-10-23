package br.com.apiWebQuest.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.apiWebQuest.model.UserModel;



public interface IUserRepository extends JpaRepository<UserModel, UUID> {
     UserModel save(UserModel userModel);
     UserDetails findByLogin(String login);
}
