package edu.eci.cvds.servlet;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.lang.Math;

import static java.lang.Math.sqrt;


@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
public class CalculadoraBean {
    private int[] numbers;
    private double mode;
    private double mean;
    private double variance;
    private int length;

    private CalculadoraBean(){
    }

    public double calculateMean(int[] list){
        setNumbers(list);
        int prom = 0;
        for (int i = 0; i < length; i++){
            prom += numbers[i];
        }
        return prom/ length;
    }
    public double calculateStandardDeviation(int[] list){
        return sqrt(calculateVariance(list));
    }
    public double calculateVariance(int[] list){
        double media = calculateMean(list);
        double act = 0;
        for (int i = 0; i < length; i++){
            double temp = (media - numbers[i]) * (media - numbers[i]);
            act += temp;
        }
        return act/media;
    }
    public double calculateMode(int[] list){
        setNumbers(list);
        int times = -1,count;
        mode = 0;
        for(int i = 0; i < length; i++){
            double act = numbers[i];
            count = 0;
            for (int j = i; j < length; j++){
                if (list[j] == i){
                    count++;
                }
            }
            if (count > times){
                mode = act;
                times = count;
            }
        }
        return mode;
    }
    public void restart(){
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
        setLength(numbers.length);
    }

    public double getMode() {
        return mode;
    }

    public void setMode(double mode) {
        this.mode = mode;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getVariance() {
        return variance;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
