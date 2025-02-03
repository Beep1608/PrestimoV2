package views.utils;

import java.io.InputStream;
import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ResourceLoader {

    public ResourceLoader(){

    }
    
    public static URL loadURL (String path){
        return ResourceLoader.class.getResource(path);
    }

    public static String load(String path){
        return loadURL(path).toString();
    }
    public static InputStream loadStream(String name){
        return ResourceLoader.class.getResourceAsStream(name);
    }

    /**
     *  Crea un icono
     * @param resource ubicación de la imagen e.i: "/dashboard/algo.png"
     * @param size ancho y alto del icono
     * @return regresa un objeto capaz de agregarse a cualquier {{@Node}}
     */
    public static ImageView makeIcon(String resource, double size){
         Image image = new Image(ResourceLoader.load("/images"+resource), 
         size, 
         size,
         true, 
         true);
         return new ImageView(image);
    }
}
