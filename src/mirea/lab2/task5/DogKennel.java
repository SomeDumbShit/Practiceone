package mirea.lab2.task5;


public class DogKennel {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[3];   // массив на 3 собаки

        // Добавляем собак в массив
        dogs[0] = new Dog("Шарик", 3);
        dogs[1] = new Dog("Бобик", 5);
        dogs[2] = new Dog("Рекс", 1);

        // Проходим по массиву и печатаем каждую собаку
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i]);
        }

        // Проверим сеттер: у Рекса день рождения
        dogs[2].setAge(2);
        System.out.println("После дня рождения: " + dogs[2]);
    }
}
