/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.study.factory;

/**
 *
 * @author Ayrat
 */
public class ColorFactory extends AbstractFactory{
    //должен иметь метод получения экземпляра Color
    public Color getColor(String colorType){
        if(colorType.equalsIgnoreCase("Red")){
            return new Red();
        }
        else if(colorType.equalsIgnoreCase("Green")){
            return new Green();
        }
        else if(colorType.equalsIgnoreCase("Blue")){
            return new Blue();
        }
        else return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
