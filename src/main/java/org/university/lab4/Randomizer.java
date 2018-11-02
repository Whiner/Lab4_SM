package org.university.lab4;

import java.util.Random;

public class Randomizer {
    private Random r = new Random();

    private double m_Normal = 5;
    private double cko_Normal = 1;
    private double m_Uniform = 5;
    private double cko_Uniform = 0.5;

    private final int n = 10;

    public double getKcu(){
        return r.nextDouble();
    }

    public double getUniformY(){
        return getUniformY(m_Uniform - cko_Uniform, m_Uniform + cko_Uniform);
    }

    private double getUniformY(double a, double b){
        return a + (b - a) * getKcu();
    }

    public double getNormalY(){
        double y = 0;
        for (int i = 0; i < n; i++) {
            double a = m_Normal / n - (Math.sqrt(3) * cko_Normal) / n;
            double b = m_Normal / n + (Math.sqrt(3) * cko_Normal) / n;
            double uniformY = getUniformY(a, b);
            y += uniformY;
        }
        return y;
    }

    public double getM_Normal() {
        return m_Normal;
    }

    public void setM_Normal(double m_Normal) {
        this.m_Normal = m_Normal;
    }

    public double getCko_Normal() {
        return cko_Normal;
    }

    public void setCko_Normal(double cko_Normal) {
        this.cko_Normal = cko_Normal;
    }

    public double getM_Uniform() {
        return m_Uniform;
    }

    public void setM_Uniform(double m_Uniform) {
        this.m_Uniform = m_Uniform;
    }

    public double getCko_Uniform() {
        return cko_Uniform;
    }

    public void setCko_Uniform(double cko_Uniform) {
        this.cko_Uniform = cko_Uniform;
    }
}
