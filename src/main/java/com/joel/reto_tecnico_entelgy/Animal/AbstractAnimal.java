package com.joel.reto_tecnico_entelgy.Animal;

import com.joel.reto_tecnico_entelgy.Animal.Enums.AnimalType;
import com.joel.reto_tecnico_entelgy.Animal.Interfaces.IAnimal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractAnimal implements IAnimal {
    
    protected String name;
    protected AnimalType type;
    protected String onomatopoeia;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public AnimalType getType() {
        return type;
    }

    @Override
    public String getOnomatopoeia() {
        return onomatopoeia;
    }

    // Implementación de los métodos de la interfaz
    @Override
    public boolean isTerrestrial() {
        return this.type == AnimalType.TERRESTRIAL;
    }

    @Override
    public boolean isFlying() {
        return this.type == AnimalType.FLYING;
    }

    @Override
    public boolean isAquatic() {
        return this.type == AnimalType.AQUATIC;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + type + ", Onomatopoeia: " + onomatopoeia;
    }
}
