import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.Serializable;


public class RecIntegral extends Lab1 implements Serializable {
     
    Double values[];
    double down;
    double up;
    double step;
    double res;
 
    public RecIntegral (double a, double b, double h, double result) {
        down = a;
        up = b;
        step = h;
        res = result;
        
        values = new Double[4];
        values[0] = down;
        values[1] = up;
        values[2] = step;
        values[3] = res;
        
    }
    
    public RecIntegral(double a, double b, double h) {
        down = a;
        up = b;
        step = h;
    }
    
    public double getDownLimit() {
        return down;
    }
    
    public double getUpLimit() {
        return up;
    }
    
    public double getStep() {
        return step;
    }
    
    public void setResult(double result) {
        res = result;
    }
    
    public Double[] getValue() {
        return values;
    }
}
