/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static Syllabizator.Syllabizator.syllabize;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import java.io.File;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.FileChooser;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author maciejszwaczka
 */
public class SyllabizatorFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        final Net net=new Net();
        Button setTrainingSetBtn = new Button();
        final TextArea resultLabel=new TextArea();
        resultLabel.setMaxHeight(220);
        resultLabel.setMaxWidth(240);
        resultLabel.setTranslateY(0);
        resultLabel.setTranslateX(40);
        setTrainingSetBtn.setTranslateX(-135);
        setTrainingSetBtn.setTranslateY(-100);
        setTrainingSetBtn.setText("Wybierz zestaw");
        setTrainingSetBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                File trainingSet;
                    FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Wybierz zestaw treningowy");
                fileChooser.getExtensionFilters().addAll(
                   new ExtensionFilter("Text Files", "*.txt"));
                /*= fileChooser.showOpenDialog(null)*/
                trainingSet=fileChooser.showOpenDialog(null);
            
                String[] tmp;
                try {
                System.out.print("aeaeae"+trainingSet.getAbsolutePath());
                BufferedReader br = new BufferedReader(new FileReader(trainingSet));
                
                String word = br.readLine();
                while(word != null){
                    System.out.println(word);
                    tmp = syllabize(word, "PL").split("-");
                    if(word.length()>1)
                    {
                    
                    for (int i=0; i<tmp.length; i++){
                        if(i == 0)
                            net.add(tmp[0], null, null);
                        else if (i==1)
                            net.add(tmp[1], tmp[0],null);
                        else
                            net.add(tmp[1], tmp[0],null);
                    }
                    }
                    word = br.readLine();
                    
                }
                br.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SyllabizatorFX.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(SyllabizatorFX.class.getName()).log(Level.SEVERE, null, ex);
                }
                    net.setUnconditionalProbs();
                    net.setConditionalProbs();
                }
            });
        Button generateTextBtn = new Button();
        generateTextBtn.setText("Generuj tekst");
        /*generateTextBtn.setMaxSize(40, 10);*/
        generateTextBtn.setTranslateX(-140);
        generateTextBtn.setTranslateY(-70);
        generateTextBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String result="";
                int verseLength = 10;
                VerseStructureGenerator vsg = new VerseStructureGenerator(verseLength);
                for(int i=0; i<100; i++){
                    int[] verseDistribution = vsg.getRandomDistribution();
                    for(int sylsInWord : verseDistribution){
                        Node syllable = net.getFirstSyllable();
                        System.out.print(syllable.getSyllable());
                        result=result.concat(syllable.getSyllable());
                        for(int j=1; j<sylsInWord; j++){
                            syllable = syllable.nextNode();
                            System.out.print(syllable.getSyllable());  
                            result=result.concat(syllable.getSyllable());
                        }
                        System.out.print(" ");
                        result=result.concat(" ");
                    }
                    System.out.println();
                    result=result.concat("\n");
                    if(i%4==3){
                        System.out.println();
                        result=result.concat("\n");
                    }
                }
                resultLabel.setText(result);
                    }
        });
        
        
        StackPane root = new StackPane();
        root.getChildren().add(setTrainingSetBtn);
        root.getChildren().add(generateTextBtn);
        root.getChildren().add(resultLabel);
        
        Scene scene = new Scene(root, 370, 250);
        
        primaryStage.setTitle("SI Projekt 160777|160560|160322");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
