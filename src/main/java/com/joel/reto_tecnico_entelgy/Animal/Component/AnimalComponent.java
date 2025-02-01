package com.joel.reto_tecnico_entelgy.Animal.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.joel.reto_tecnico_entelgy.Animal.AnimalData;
import com.joel.reto_tecnico_entelgy.Animal.Enums.AnimalType;

@Component
public class AnimalComponent {
    
    public List<AnimalData> listAnimal(String[] args){
        List<AnimalData> animalDataList = new ArrayList<>();

        for(String arg: args){
            String[] parts = arg.split("\\|");

            if (parts.length == 3) {
                String name = parts[0];
                AnimalType type = AnimalType.valueOf(parts[1].toUpperCase());
                String onomatopoeia = parts[2];

                AnimalData animalData = new AnimalData(name, type, onomatopoeia);
                animalDataList.add(animalData);
            }else{
                System.out.println("Formato incorrecto para: " + arg);
            }
        }
        return animalDataList;
    }

    public void displayAnimalsGroupedByType(List<AnimalData> animalDataList){
        Map<AnimalType, List<AnimalData>> animalDataMap = animalDataList.stream()
            .collect(Collectors.groupingBy(AnimalData::getType));

        animalDataMap.forEach((type, animals) -> {
            System.out.println("Tipo: " + type);
            animals.forEach(animal -> System.out.println("- " + animal));
        });
    }
}
