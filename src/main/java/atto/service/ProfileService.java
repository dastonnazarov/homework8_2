package atto.service;

import atto.container.ComponentContainer;

import atto.controller.AdminController;
import atto.controller.MenuController;
import atto.controller.ProfileController;
import atto.controller.UserController;
import atto.dto.Profile;
import atto.enums.ProfileStatus;
import atto.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
@Service
public class ProfileService {
    @Autowired
    private UserController userController;
    @Autowired
    private AdminController adminController;
    @Autowired
    private MenuController menuController;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileController profileController;


    public void loginProfile(Profile profile) {
        Profile existsPhone = profileRepository.getProfileByPhone(profile.getPhone());

        if (existsPhone != null && existsPhone.getId() == -1) {
            adminController.adminSectionMenu();
        } else if (existsPhone != null && existsPhone.getId() != -1) {
            userController.userCardMenu();
        } else if (existsPhone == null) {
            System.out.println("You haven't registered yet!!!");
            menuController.singUpMenu();
        } else {
            registrationProfile(profile);
        }

    }

    public void registrationProfile(Profile profile) {
        profile.setCreate_date(LocalDate.now());
        profileRepository.saveProfile(profile);
        System.out.println("successfully registered");
        menuController.singUpMenu();
    }

    public void allProfileList() {
        List<Profile>profileList = profileRepository.getAllProfile();
        System.out.println("----------   Profile List ----------");
        profileList.forEach(profile -> System.out.println(profile));
        profileController.adminProfileMenu();

    }

    public void profileChangeStatusByPhone(String phone) {
        Profile exist = profileRepository.getProfileByPhone(phone);
        if (exist == null) {
            System.out.println("Sorry status isn't exist or not found profile phone");
            return;
        } else if (exist.getStatus().equals(ProfileStatus.ACTIVE)) {
            profileRepository.updateProfileByStatus(ProfileStatus.BLOCK.name(), phone);
            profileController.adminProfileMenu();

        } else if ( exist.getStatus().equals(ProfileStatus.BLOCK)) {
            profileRepository.updateProfileByStatus(ProfileStatus.ACTIVE.name(), phone);
            profileController.adminProfileMenu();
        }

        }

}
