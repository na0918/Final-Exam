package com.company;

public class Main {

    public static void main(String[] args) {

        SimulatedAnnealing sa = new SimulatedAnnealing(1, 0.95, 100);
        sa.solve(new Problem() {
            @Override
            public double fit(double x) {
                return 0.16*x*x*x*x -x*x + 0.37*x + 5;
            }

            @Override
            public boolean isNeighborBetter(double f0, double f1) {
                return f1 > f0;
            }
        }, 0, 31);

        System.out.println(sa.hist);
        double min = sa.hist.get(0);

        for(int i=0;i<sa.hist.size();i++) {
            if(min>sa.hist.get(i)) {
                min = sa.hist.get(i);
            }
        }
        System.out.println("전역 최적점 : "+min);
    }
}
