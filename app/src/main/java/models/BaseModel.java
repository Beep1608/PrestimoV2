package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface BaseModel {
    IntegerProperty idProperty();
    StringProperty searchStringProperty();
}