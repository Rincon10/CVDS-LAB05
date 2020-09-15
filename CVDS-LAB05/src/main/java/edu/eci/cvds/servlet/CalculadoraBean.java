package edu.eci.cvds.servlet;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.lang.Math;

import static java.lang.Math.sqrt;


@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
public class CalculadoraBean {
    private int number;
    private int attempts;
    private int price;
    private String status;

    private CalculadoraBean(){
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public int getAttempts(){
        return attempts;
    }
    public void setAttempts(int attempts){
        this.attempts = attempts;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public double calculateMean(int[] list){
        int prom = 0;
        for (int i = 0; i < list.length; i++){
            prom += list[i];
        }
        return prom/ list.length;
    }
    public double calculateStandardDeviation(int[] list){
        return sqrt(calculateVariance(list));
    }
    public double calculateVariance(int[] list){
        double media = calculateMean(list);
        double act = 0;
        for (int i = 0; i < list.length; i++){
            double temp = (media - list[i]) * (media - list[i]);
            act += temp;
        }
        return act/media;
    }
    public double calculateMode(int[] list){
        int times = -1,count;
        double mode = 0;
        for(int i = 0; i < list.length; i++){
            double act = list[i];
            count = 0;
            for (int j = i; j < list.length; j++){
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

}
