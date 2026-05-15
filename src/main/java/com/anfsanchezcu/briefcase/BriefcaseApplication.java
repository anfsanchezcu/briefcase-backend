package com.anfsanchezcu.briefcase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anfsanchezcu.briefcase.Entities.Experience;
import com.anfsanchezcu.briefcase.Entities.Skill;
import com.anfsanchezcu.briefcase.Servicies.ExperienceServiceImp;

@SpringBootApplication
public class BriefcaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(BriefcaseApplication.class, args);

  }

}
