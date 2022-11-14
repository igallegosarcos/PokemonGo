/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.curso.pokemoncasigo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author igallego
 */
public class PokemonCasiGo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepPlaying = true;
        ArrayList<Pokemon> listPokemon = new ArrayList();
        ArrayList<Pokemon> pokeball = new ArrayList();
        //Lista de pokemon disponibles
        Pokemon pokemon1 = new Pokemon("Bulbasaur", 1, "planta");
        Pokemon pokemon2 = new Pokemon("Charmander", 2, "fuego");
        Pokemon pokemon3 = new Pokemon("Squirtle", 3, "agua");
        Pokemon pokemon4 = new Pokemon("Chikorita", 4, "planta");
        Pokemon pokemon5 = new Pokemon("Ponyta", 5, "fuego");
        Pokemon pokemon6 = new Pokemon("Piplup", 6, "agua");
        Pokemon pokemon7 = new Pokemon("Oddish", 7, "planta");
        Pokemon pokemon8 = new Pokemon("Cyndaquil", 8, "fuego");
        Pokemon pokemon9 = new Pokemon("Psyduck",9,"agua");
        Pokemon pokemon10 = new Pokemon ("Poliwag", 10, "agua");

        // Los añado a la lista de pokemon disponibles
        listPokemon.add(pokemon1);
        listPokemon.add(pokemon2);
        listPokemon.add(pokemon3);
        listPokemon.add(pokemon4);
        listPokemon.add(pokemon5);
        listPokemon.add(pokemon6);
        listPokemon.add(pokemon7);
        listPokemon.add(pokemon8);
        listPokemon.add(pokemon9);
        listPokemon.add(pokemon10);
        do {
            System.out.println("Elige si quieres entrenar, capturar, evolucionar o combatir contra otro pokemon. Si quieres salir, escribe exit.");
            String option = sc.nextLine();
            switch (option) {
                case "capturar":
                    Random numberRandom = new Random();
                    int number = numberRandom.nextInt(listPokemon.size());
                    Pokemon pokemonRandom = listPokemon.get(number);
                    pokemonRandom.randomLevel();
                    pokemonRandom.randomPower();
                    Pokemon pokemonCopy = new Pokemon(pokemonRandom);
                    pokeball.add(pokemonCopy);
                    System.out.println("Has capturado a: " + pokemonRandom.getName() + " de nivel "
                            + pokemonRandom.getLevel() + " y fuerza " + pokemonRandom.getPower());
                    break;
                case "entrenar":
                    System.out.println("Tu pokeball tiene a");
                    for (int i = 0; i < pokeball.size(); i++) {
                        System.out.println(pokeball.get(i).getName() + " posición " + i + " con nivel " + pokeball.get(i).getLevel());
                    }
                    try {
                        System.out.println("Elige el número del pokemon que quieres entrenar");
                        int choose = sc.nextInt();
                        sc.nextLine();
                        pokeball.get(choose).train();
                        System.out.println("Felicidades " + pokeball.get(choose).getName() + " es ahora de nivel " + pokeball.get(choose).getLevel());
                    } catch (Exception ArrayIndexOutOfBoundsException) {
                        System.out.println("Elige una posición disponible");
                    }
                    break;
                case "combatir":
                    Random numberRandomEnemy = new Random();
                    int numberEnemy = numberRandomEnemy.nextInt(listPokemon.size());
                    Pokemon pokemonRandomEnemy = listPokemon.get(numberEnemy);
                    pokemonRandomEnemy.randomLevel();
                    pokemonRandomEnemy.randomPower();
                    System.out.println("Vas a combatir contra " + pokemonRandomEnemy.getName() + " de nivel "
                            + pokemonRandomEnemy.getLevel() + " y fuerza " + pokemonRandomEnemy.getPower());
                    System.out.println("Tu pokeball tiene a");
                    for (int i = 0; i < pokeball.size(); i++) {
                        System.out.println(pokeball.get(i).getName() + " posición " + i + " con nivel "
                                + pokeball.get(i).getLevel() + " y fuerza " + pokeball.get(i).getPower());
                    }
                    try {
                        System.out.println("Elige el número del pokemon con el que quieres combatir");
                        int choose = sc.nextInt();
                        sc.nextLine();
                        int levelBefore = pokeball.get(choose).getLevel();
                        pokeball.get(choose).fight(pokemonRandomEnemy);
                        if(levelBefore!=pokeball.get(choose).getLevel()){
                        System.out.println("Ahora tu pokemon es de nivel " + pokeball.get(choose).getLevel());
                        }
                    } catch (Exception ArrayIndexOutOfBoundsException) {
                        System.out.println("Elige una posición disponible");
                    }

                    break;

                case "evolucionar":
                    System.out.println("Tu pokeball tiene a");
                    for (int i = 0; i < pokeball.size(); i++) {
                        System.out.println(pokeball.get(i).getName() + " posición " + i + " con nivel " + pokeball.get(i).getLevel());
                    }
                    try {
                        System.out.println("¿Qué pokemon quieres evolucionar? Debe ser de nivel al menos 5.");
                        int choose = sc.nextInt();
                        sc.nextLine();
                        String nameBefore=pokeball.get(choose).getName();
                        pokeball.get(choose).evolve();
                        Pokemon pokemonEvolve = new Pokemon(pokeball.get(choose));
                        if(!nameBefore.equals(pokemonEvolve.getName())){
                        System.out.println("Felicidades, tu pokemon es ahora "
                                + pokemonEvolve.getName() + " y tiene fuerza " + pokeball.get(choose).getPower());
                        }
                    } catch (Exception ArrayIndexOutOfBoundsException) {
                        System.out.println("Elige una posición disponible");
                    }
                    break;

                case "exit":
                    keepPlaying = false;
                    break;
                default:
                    System.out.println("Prueba de nuevo");
                    break;

            }
        } while (keepPlaying);

    }
}
