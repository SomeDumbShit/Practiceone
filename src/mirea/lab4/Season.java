package mirea.lab4;

public enum Season {
    // у каждой константы в скобках средняя температура, она передается в конструктор
    WINTER(-10),
    SPRING(5),
    SUMMER(20) {
        @Override
        public String getDescription() {           // для лета переопределяем метод
            return "Теплое время года";
        }
    },
    AUTUMN(7);                                     // после последней константы ставится точка с запятой

    private final int averageTemperature;          // поле: средняя температура

    private Season(int averageTemperature) {       // конструктор enum всегда private
        this.averageTemperature = averageTemperature;
    }

    public int getAverageTemperature() {           // геттер температуры
        return averageTemperature;
    }

    public String getDescription() {               // описание по умолчанию для всех времен года
        return "Холодное время года";
    }
}
