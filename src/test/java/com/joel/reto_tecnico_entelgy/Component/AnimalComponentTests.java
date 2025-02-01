package com.joel.reto_tecnico_entelgy.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.joel.reto_tecnico_entelgy.Animal.AnimalData;
import com.joel.reto_tecnico_entelgy.Animal.Component.AnimalComponent;
import com.joel.reto_tecnico_entelgy.Animal.Enums.AnimalType;

public class AnimalComponentTests {
    
    private AnimalComponent animalComponent;

    @BeforeEach
    void setUp() {
        animalComponent = new AnimalComponent();
    }

    @Test
    void testListAnimal_withValidData(){
        String[] args = {"León|TERRESTRIAL|Rugido","Delfín|AQUATIC|Chirrido","Tiburón|AQUATIC|Gruñido","Ballena|AQUATIC|Canto","Elefante|TERRESTRIAL|Barrito","Águila|FLYING|Grito"};
        List<AnimalData> animalDataList = animalComponent.listAnimal(args);

        assertEquals(6, animalDataList.size(), "La lista debe de contener 6 elementos");

        AnimalData leon = animalDataList.get(0);
        assertEquals("León", leon.getName(), "El nombre del animal debe de ser León");
        assertEquals(AnimalType.TERRESTRIAL, leon.getType(), "El tipo del animal debe de ser TERRESTRIAL");
        assertEquals("Rugido", leon.getOnomatopoeia(), "El sonido del animal debe de ser Rugido");

        AnimalData delfin = animalDataList.get(1);
        assertEquals("Delfín", delfin.getName(), "El nombre del animal debe de ser Delfín");
        assertEquals(AnimalType.AQUATIC, delfin.getType(), "El tipo del animal debe de ser AQUATIC");
        assertEquals("Chirrido", delfin.getOnomatopoeia(), "El sonido del animal debe de ser Chirrido");

        AnimalData tiburon = animalDataList.get(2);
        assertEquals("Tiburón", tiburon.getName(), "El nombre del animal debe de ser Tiburón");
        assertEquals(AnimalType.AQUATIC, tiburon.getType(), "El tipo del animal debe de ser AQUATIC");
        assertEquals("Gruñido", tiburon.getOnomatopoeia(), "El sonido del animal debe de ser Gruñido");

        AnimalData ballena = animalDataList.get(3);
        assertEquals("Ballena", ballena.getName(), "El nombre del animal debe de ser Ballena");
        assertEquals(AnimalType.AQUATIC, ballena.getType(), "El tipo del animal debe de ser AQUATIC");
        assertEquals("Canto", ballena.getOnomatopoeia(), "El sonido del animal debe de ser Canto");

        AnimalData elefante = animalDataList.get(4);
        assertEquals("Elefante", elefante.getName(), "El nombre del animal debe de ser Elefante");
        assertEquals(AnimalType.TERRESTRIAL, elefante.getType(), "El tipo del animal debe de ser TERRESTRIAL");
        assertEquals("Barrito", elefante.getOnomatopoeia(), "El sonido del animal debe de ser Barrito");

        AnimalData aguila = animalDataList.get(5);
        assertEquals("Águila", aguila.getName(), "El nombre del animal debe de ser Águila");
        assertEquals(AnimalType.FLYING, aguila.getType(), "El tipo del animal debe de ser FLYING");
        assertEquals("Grito", aguila.getOnomatopoeia(), "El sonido del animal debe de ser Grito");
    }

    @Test
    void testDisplayAnimalsGroupByType(){
        String[] args = {"León|TERRESTRIAL|Rugido","Delfín|AQUATIC|Chirrido","Tiburón|AQUATIC|Gruñido","Ballena|AQUATIC|Canto","Elefante|TERRESTRIAL|Barrito","Águila|FLYING|Grito"};
        List<AnimalData> animalDataList = animalComponent.listAnimal(args);

        Map<AnimalType, List<AnimalData>> groupedAnimals = animalDataList.stream()
            .collect(Collectors.groupingBy(AnimalData::getType));

        assertTrue(groupedAnimals.containsKey(AnimalType.AQUATIC));
        assertEquals(3, groupedAnimals.get(AnimalType.AQUATIC).size(), "El grupo AQUATIC debe de contener 3 elementos");

        assertTrue(groupedAnimals.containsKey(AnimalType.TERRESTRIAL));
        assertEquals(2, groupedAnimals.get(AnimalType.TERRESTRIAL).size(), "El grupo TERRESTRIAL debe de contener 2 elementos");
    
        assertTrue(groupedAnimals.containsKey(AnimalType.FLYING));
        assertEquals(1, groupedAnimals.get(AnimalType.FLYING).size(), "El grupo FLYING debe de contener 1 elemento");
    }
}
