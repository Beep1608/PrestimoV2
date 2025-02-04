package models.percentages;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class PercentagesBuyJewelry {
    private final SimpleDoubleProperty min_percentage = new SimpleDoubleProperty(0.7); 
    private final SimpleDoubleProperty mid_percentage = new SimpleDoubleProperty(0.8); 
    private final SimpleDoubleProperty max_percentage = new SimpleDoubleProperty(0.9); 
    private final SimpleDoubleProperty applied_percentage = new SimpleDoubleProperty(0); 
    public PercentagesBuyJewelry(){

    }
    public DoubleProperty min(){
        return this.min_percentage;
    }
    public DoubleProperty inter(){
        return this.mid_percentage;
    }
    public DoubleProperty max(){
        return this.max_percentage;
    }
    public DoubleProperty applied(){
        return this.applied_percentage;
    }
}
