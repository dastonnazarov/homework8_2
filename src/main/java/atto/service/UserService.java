package atto.service;

import atto.container.ComponentContainer;
import atto.dto.Card;
import atto.dto.Profile;
import atto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addCard(Card card) {
        Profile exists = userRepository.getUserByPhone(card.getPhone());

        if (exists != null && exists.getPhone().equals(card.getPhone())) {
          userRepository.saveUserCard(card);
        }  else {
//            registrationProfile(profile);
        }
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
