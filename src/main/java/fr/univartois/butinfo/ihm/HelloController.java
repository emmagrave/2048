/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022-2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.ihm;

import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


/**
 * La classe HelloController illustre le fonctionnement du contrôleur associé à une vue.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class HelloController {
	
	private Label[][] tileLabels = new Label[4][4];

	@FXML
    private BorderPane borderPane;
	
	@FXML
    private Button buttonDown;

    @FXML
    private GridPane buttonGrid;

    @FXML
    private Button buttonLeft;

    @FXML
    private Button buttonReset;

    @FXML
    private Button buttonRight;

    @FXML
    private Button buttonUp;

    @FXML
    private GridPane gameGrid;

    @FXML
    private Label score;
    
    private Grid grille;
    
    private Random rand;
    
    private int scoreJoueur;

    @FXML
    void Down(ActionEvent event) {
    	MoveResult deplacement = grille.moveDown();
    	if(deplacement.hasMoved() == false) {
    		return ;
    	}
    	scoreJoueur += deplacement.getMergeScore();
    	score.setText(String.valueOf(scoreJoueur));
    	valeurAleatoire();
    	maj();
    	if(grille.isBlocked() == true) {
    		buttonUp.setDisable(true);
    		buttonDown.setDisable(true);
    		buttonLeft.setDisable(true);
    		buttonRight.setDisable(true);
    	}
    }

    @FXML
    void Left(ActionEvent event) {
    	MoveResult deplacement = grille.moveLeft();
    	if(deplacement.hasMoved() == false) {
    		return ;
    	}
    	scoreJoueur += deplacement.getMergeScore();
    	score.setText(String.valueOf(scoreJoueur));
    	valeurAleatoire();
    	maj();
    	if(grille.isBlocked() == true) {
    		buttonUp.setDisable(true);
    		buttonDown.setDisable(true);
    		buttonLeft.setDisable(true);
    		buttonRight.setDisable(true);
    	}
    }

    @FXML
    void Reset() {
    	grille.clear();
    	valeurAleatoire();
    	valeurAleatoire();
    	maj();
    	scoreJoueur = 0;
    	score.setText(String.valueOf(scoreJoueur));
    	buttonUp.setDisable(false);
		buttonDown.setDisable(false);
		buttonLeft.setDisable(false);
		buttonRight.setDisable(false);
    }

    @FXML
    void Right(ActionEvent event) {
    	MoveResult deplacement = grille.moveRight();
    	if(deplacement.hasMoved() == false) {
    		return ;
    	}
    	scoreJoueur += deplacement.getMergeScore();
    	score.setText(String.valueOf(scoreJoueur));
    	valeurAleatoire();
    	maj();
    	if(grille.isBlocked() == true) {
    		buttonUp.setDisable(true);
    		buttonDown.setDisable(true);
    		buttonLeft.setDisable(true);
    		buttonRight.setDisable(true);
    	}
    }

    @FXML
    void Up(ActionEvent event) {
    	MoveResult deplacement = grille.moveUp();
    	if(deplacement.hasMoved() == false) {
    		return ;
    	}
    	scoreJoueur += deplacement.getMergeScore();
    	score.setText(String.valueOf(scoreJoueur));
    	valeurAleatoire();
    	maj();
    	if(grille.isBlocked() == true) {
    		buttonUp.setDisable(true);
    		buttonDown.setDisable(true);
    		buttonLeft.setDisable(true);
    		buttonRight.setDisable(true);
    	}
    }
    
    @FXML
    void initialize() {
    	grille = new Grid();
    	rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Label label = new Label();
                gameGrid.add(label, j, i);
                tileLabels[i][j] = label;
                label.setPrefHeight(49);
                label.setPrefWidth(49);
                label.setAlignment(Pos.CENTER);
            }
        }
    }
    
    void valeurAleatoire() {
    	List<Tile> tiles = grille.availableTiles();
    	int indiceAleatoire = rand.nextInt(tiles.size());
    	Tile tile = tiles.get(indiceAleatoire);
    	double valeurAleatoire = rand.nextDouble();
    	if (valeurAleatoire < 0.9) {
    		tile.setValue(2);
    	}
    	else {
    		tile.setValue(4);
    	}
    }
    
    void maj() {
    	for (int i = 0; i < tileLabels.length; i++) {
    		for (int j = 0; j < tileLabels[0].length; j++) {
    			Tile tile = grille.get(i, j);
    			if(tile.getValue() != 0) {
    				tileLabels[i][j].setText(String.valueOf(tile.getValue()));
    			} else {
    				tileLabels[i][j].setText("");
    			}
    			tileLabels[i][j].setBackground(computeBackground(tile.getValue()));
    			
    		}
    	}
    }
    
    private static Background computeBackground(int value) {
	    	if (value == 0) {
	            return new Background(
	                    new BackgroundFill(
	                            Color.WHITE,
	                            CornerRadii.EMPTY,
	                            Insets.EMPTY));
	        }
    	   // On calcule d'abord à quelle puissance de 2 la valeur correspond.
    	   int powerOf2 = 0;
    	   while ((value >> powerOf2) > 0) {
    	      powerOf2++;
    	   }

    	   // On détermine ensuite à quel pourcentage de la valeur maximale elle correspond.
    	   double maxPower = 1. + Grid.SIZE * Grid.SIZE;
    	   double pct = powerOf2 / maxPower;

    	   double greenLevel = 0.5 + 0.4 * (1 - pct);
    	   // On crée enfin l'arrière-plan à partir de ce pourcentage.
    	   return new Background(
    	            new BackgroundFill(
    	                  new Color(1 - pct, greenLevel, 1 - pct, 1),
    	                  CornerRadii.EMPTY,
    	                  Insets.EMPTY));
    	}

    


}
