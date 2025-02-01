package com.joel.reto_tecnico_entelgy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joel.reto_tecnico_entelgy.Animal.AnimalData;
import com.joel.reto_tecnico_entelgy.Animal.Component.AnimalComponent;

@SpringBootApplication
public class RetoTecnicoEntelgyApplication implements CommandLineRunner {

    @Autowired
    private AnimalComponent animalComponent;

    public static void main(String[] args) {
        SpringApplication.run(RetoTecnicoEntelgyApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length == 0) {
            System.out.println("No arguments provided");
            return;
        }

        List<AnimalData> animalDataList = animalComponent.listAnimal(args);
        animalComponent.displayAnimalsGroupedByType(animalDataList);
        
    }
}
