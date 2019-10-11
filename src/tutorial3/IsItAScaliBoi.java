package tutorial3;

import javax.swing.*;
import java.awt.*;

public class IsItAScaliBoi {
    public static void main(String[] args){
        int coldBlooded = JOptionPane.showConfirmDialog(null, "Is your animal Cold Blooded");
        if(!(coldBlooded==JOptionPane.YES_OPTION||coldBlooded==JOptionPane.NO_OPTION)){
            System.exit(0);
        }
        if(coldBlooded==JOptionPane.YES_OPTION){
            // Cold Blooded
            int scaly = JOptionPane.showConfirmDialog(null, "Is your animal scaly?");
            if(!(scaly==JOptionPane.YES_OPTION||scaly==JOptionPane.NO_OPTION)){
                System.exit(0);
            }
            if(scaly==JOptionPane.YES_OPTION){
                int hasFins = JOptionPane.showConfirmDialog(null, "Does your animal have fins");
                if(!(hasFins==JOptionPane.YES_OPTION||hasFins==JOptionPane.NO_OPTION)){
                    System.exit(0);
                }
                if(hasFins==JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Your Animal is a fish");
                } else{
                    JOptionPane.showMessageDialog(null, "Your animal is a reptile");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Your animal is an amphibian");
            }
        } else {
            // Warm Blooded
            int feathered = JOptionPane.showConfirmDialog(null, "Does your animal have feathers?");
            if(!(feathered==JOptionPane.YES_OPTION||feathered==JOptionPane.NO_OPTION)){
                System.exit(0);
            }
            if(feathered== JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Your animal is a bird");
            } else {
                JOptionPane.showMessageDialog(null, "Your animal is a mammal");
            }
        }
        main(new String[1]);
    }
}
