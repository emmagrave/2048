# 2048 Game

Bienvenue dans l'application **2048** ! Ce jeu de puzzle est basé sur le jeu populaire où l'objectif est de combiner des tuiles jusqu'à atteindre le nombre 2048.

## Description

Le jeu 2048 est un jeu de puzzle dans lequel le joueur doit combiner des tuiles de même valeur pour atteindre le score final de 2048. À chaque mouvement, une nouvelle tuile (2 ou 4) apparaît aléatoirement sur la grille. Le joueur doit combiner ces tuiles en les faisant glisser dans une des quatre directions : haut, bas, gauche ou droite. Le jeu se termine lorsque le joueur atteint le nombre 2048 ou ne peut plus faire de mouvement.
**Ce projet a été réalisé lors de ma première année de BUT Informatique** dans le cadre d'un travail pratique. C'était une excellente opportunité pour appliquer les concepts de programmation et de gestion de projet tout en développant une application de type jeu.

## Fonctionnalités

- Grille de jeu de 4x4 tuiles.
- Déplacements et combinaisons des tuiles vers les quatre directions.
- Score actuel affiché et mise à jour dynamique.
- Condition de victoire (atteindre 2048) et de défaite (aucun mouvement possible).

## Technologies utilisées

- **Java** : Langage principal pour la logique du jeu.
- **Gradle** : Outil de construction et de gestion des dépendances.
- **Eclipse** : Environnement de développement (IDE) utilisé pour le développement du projet.

## Prérequis

- **Java 17** : Le projet est configuré pour fonctionner avec Java 17.
- **Gradle 8.3** (ou plus récent) : Assurez-vous que Gradle est installé ou utilisez le wrapper inclus.

## Installation

1. Clonez ce dépôt sur votre machine locale :
   ```bash
   git clone <url_du_dépôt>
    ```  

2. Accédez au dossier du projet :
    ```bash
    cd 2048
    ```

## Lancer le projet 
1. Assurez-vous que le wrapper Gradle est configuré :
    ```bash
    ./gradlew wrapper --gradle-version 8.3
    ```

2. Lancez le jeu avec la tâche **run** :
    ```bash
    ./gradlew run
    ```

## Auteurs
- GRAVE Emma 