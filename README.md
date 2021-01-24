# Pokemon 125
CS 125 Final Project ([Second place in Project Fair](https://cs125-old.cs.illinois.edu/info/fair/))

## Overview
Play as a CS 125 student with a team of CS 125 course staff as their respective pokemon (whom they have chosen themselves) and battle against Professor Geoffrey Challen (aka "the Challen-ger") and the different Machine Projects (MP) represented as pokemon of the professor's choice!

The game will provide four move actions: "Fight", "Run", "Cheat", and "Pokemon". "Pokemon" allows you to select between the course staff pokemon. "Fight" allows you to select a move that is offered by the currently selected pokemon. "Run" is a dead end as the game does not allow giving up entirely, similar to the course! "Cheat" is also a dead end, but it is accompanied with a scolding message that reminds the player of the course's academic integrity policy. The player will not be able to switch to pokemon that have fainted, and the appropriate toast messages will appear to communicate this. 

Quantitative values in the game are determined by unique characteristics of each pokemon. Turns are assigned based on which of the two selected pokemon have a greater speed, damage is dealt based on calculations considering the unique attack values of each move, and so forth. The game can be won by defeating all the Challen-ger's pokemon, or lost by losing all HP among the different course staff pokemon. 

This program utilizes [PokéAPI](https://pokeapi.co/), a RESTful API that we used to access each pokemon's unique information. 

## [Project Video Demo](https://youtu.be/JdTKhtDtTgc)

Note: The video demo is running the program on a simulated Pixel 2. 
