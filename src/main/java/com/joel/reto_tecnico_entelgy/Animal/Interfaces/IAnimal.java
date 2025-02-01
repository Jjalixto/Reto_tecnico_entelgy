package com.joel.reto_tecnico_entelgy.Animal.Interfaces;

import com.joel.reto_tecnico_entelgy.Animal.Enums.AnimalType;

public interface IAnimal {

    String getName();

    AnimalType getType();

    String getOnomatopoeia();

    boolean isTerrestrial(); 

    boolean isFlying();

    boolean isAquatic();
}
