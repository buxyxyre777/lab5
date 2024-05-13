import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JThread extends Thread {
    
    double sum=0;
    double up;
    double a1;
    double b1;
    double h1;
    DefaultTableModel jmodel;
    RecIntegral recIntegral;
    int rowNumber;
    
    JThread (double a, double b, double h, DefaultTableModel model, int rowNumber, RecIntegral rec) {
        up=a;
        a1 = a;
        b1 = b;
        h1 = h;
        jmodel = model;
        this.rowNumber = rowNumber;
        recIntegral = rec;
    }
    
    public Double Integral (double x) {
         return 1/Math.log(x);
    }
    
    public void setValues(double a, double b, double h, DefaultTableModel model, int rowNumber, RecIntegral rec) {
        up=a;
        a1 = a;
        b1 = b;
        h1 = h;
        jmodel = model;
        this.rowNumber = rowNumber;
        recIntegral = rec;
    }
    
    public double getResult() {
        return this.sum;
    }
    
    @Override
    public void run() {
        
        System.out.printf("%s is started...\n", Thread.currentThread().getName());
        
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException ex) {
            System.out.println("Thread was interrupted!\n");
        }
        
        double ost=(b1-a1)%h1;
        sum = h1*(0.5*(Integral(a1)+Integral(a1+ost)));
        a1=a1+ost;
        
        while (a1<=b1) {
            
            sum = sum + h1*(0.5*(Integral(a1) + Integral(a1+h1)));
            a1=a1+h1;
        }
       
        recIntegral.setResult(sum);
        jmodel.setValueAt(sum, rowNumber, 3);
        
        recIntegral.list.add(new RecIntegral(a1, b1, h1, sum));
        //System.out.print("Array Size: ");
        //System.out.print(rec.list.size());
        System.out.printf("%s was finished!\n", Thread.currentThread().getName());
        
    }
}
