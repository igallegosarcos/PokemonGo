/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.pokemoncasigo;

import java.util.Random;

/**
 *
 * @author igallego
 */
public class Pokemon {

    private String name;
    private int number;
    private String type;
    private double power;
    private int level;

    public Pokemon(String name, int number, String type) {
        this.name = name;
        this.number = number;
        this.type = type;

    }

    public Pokemon(Pokemon copyPokemon) {
        this.name = copyPokemon.getName();
        this.number = copyPokemon.getNumber();
        this.type = copyPokemon.getType();
        this.level = copyPokemon.getLevel();
        this.power = copyPokemon.getPower();
    }

    public void randomPower() {
        Random powRandom = new Random();
        this.power = powRandom.nextDouble(99) + 1;
    }

    public void randomLevel() {
        Random levelRandom = new Random();
        this.level = levelRandom.nextInt(9) + 1;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int train() {
        return ++level;
    }

    public void fight(Pokemon pokemon2) {
        if (!type.equals(pokemon2.type)) {
            switch (pokemon2.type) {
                case "fuego":
                    if ("planta".equals(type)) {
                        power = power - 30;
                    } else {
                        power = power + 30;
                    }
                    break;
                case "agua":
                    if ("fuego".equals(type)) {
                        power = power - 30;
                    } else {
                        power = power + 30;
                    }
                    break;
                case "planta":
                    if ("agua".equals(type)) {
                        power = power - 30;
                    } else {
                        power = power + 30;
                    }
                    break;
                default:
                    break;

            }
        }
        if (power > pokemon2.getPower()) {
            level++;
            System.out.println("Enhorabuena, has ganado");
        } else {
            System.out.println("Oh no, has perdido");
        }
        
    }

    public void evolve() {
        String newName = " ";
        if (level > 8) {
            power = power + 30;
            switch (name) {
                case "Bulbasaur":
                    name = "Venusaur";
                    break;
                case "Charmander":
                    name = "Charizard";
                    break;
                case "Squirtle":
                    name = "Blastoise";
                    break;
                case "Chikorita":
                    name = "Meganium";
                    break;
                case "Ponyta":
                    name = "Rapidash";
                    break;
                case "Piplup":
                    name = "Empoleon";
                    break;
                case "Psyduck":
                    name = "Golduck";
                    break;
                case "Cyndaquil":
                    name = "Typhlosion";
                    break;
                case "Oddish":
                    name = "Bellossom";
                    break;
                case "Poliwag":
                    name = "Poliwrath";
                    break;
                default:
                    break;
            }
        } else if (level > 4 && name != "Ponyta" && name != "Psyduck") {
            power = power + 10;
            switch (name) {
                case "Bulbasaur":
                    name = "Ivysaur";
                    break;
                case "Charmander":
                    name = "Charmeleon";
                    break;
                case "Squirtle":
                    name = "Wartortle";
                    break;
                case "Chikorita":
                    name = "Bayleef";
                    break;
                case "Piplup":
                    name = "Prinplup";
                    break;
                case "Cyndaquil":
                    name = "Quilava";
                    break;
                case "Oddish":
                    name = "Gloom";
                    break;
                case "Poliwag":
                    name = "Poliwhirl";
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("No puede evolucionar");
        }

    }

}
