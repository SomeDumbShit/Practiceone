package mirea.lab7.task4;

public interface MathCalculable {
    double PI = Math.PI;                           // поля интерфейса сами public static final, то есть константы

    double pow(double base, double exponent);      // возведение в степень
    double complexModule(double re, double im);    // модуль комплексного числа re + im*i
}
