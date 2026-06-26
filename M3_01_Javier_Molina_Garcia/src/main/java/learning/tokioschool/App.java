package learning.tokioschool;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello world!");

        double notas[] = {9.5, 10, 1.5, 6.3, 4.5, 5, 9, 8.5};
        DescriptiveStatistics estadisticas = new DescriptiveStatistics();

        for(double item : notas) {
            estadisticas.addValue(item);
        }

        System.out.println("El percentil 50 de las notas es:" + estadisticas.getPercentile(50));

    }
}
