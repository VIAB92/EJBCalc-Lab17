package beans;

import javax.ejb.Stateless;

/**
 * Created by Виктор on 24.12.13.
 */
@Stateless(name = "CalculatorEJB")
public class CalculatorBean {

    private double memoryValue;

    public CalculatorBean() {
    }


    public double sum(double val1, double val2) {
        return val1+val2;
    }

    public double sub(double val1, double val2) {
        return val1-val2;
    }

    public double mul(double val1, double val2) {
        return val1*val2;
    }

    public double div(double val1, double val2) {
        try
        {
            return val1/val2;
        }
        catch (Exception ex)
        {
            System.out.println("Division by 0!");
            return 0;
        }
    }

    public double getMemoryValue() {
        return memoryValue;
    }

    public void setMemoryValue(double memoryValue) {
        this.memoryValue = memoryValue;
    }

    public String test()
    {
        return "Hello, world!";
    }
}
