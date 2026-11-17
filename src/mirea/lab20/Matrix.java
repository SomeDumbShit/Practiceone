package mirea.lab20;

// задание 5: матрица на основе обобщенного типа; элементы - любые числа (Integer, Double, Long ...)
public class Matrix<T extends Number> {
    private final T[][] data;
    private final int rows;
    private final int cols;

    public Matrix(T[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Матрица пуста");
        }
        for (T[] row : data) {
            if (row.length != data[0].length) {
                throw new IllegalArgumentException("Строки матрицы разной длины");
            }
        }
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public T get(int i, int j) {
        return data[i][j];
    }

    // сложение: Matrix<? extends Number> принимает матрицу с любым числовым типом элементов
    public Matrix<Double> add(Matrix<? extends Number> other) {
        return addScaled(other, 1);
    }

    public Matrix<Double> subtract(Matrix<? extends Number> other) {
        return addScaled(other, -1);
    }

    // this + sign * other: при sign = 1 сложение, при sign = -1 вычитание
    private Matrix<Double> addScaled(Matrix<? extends Number> other, double sign) {
        if (rows != other.getRows() || cols != other.getCols()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        Double[][] result = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j].doubleValue() + sign * other.get(i, j).doubleValue();
            }
        }
        return new Matrix<>(result);
    }

    public Matrix<Double> multiply(Matrix<? extends Number> other) {
        if (cols != other.getRows()) {
            throw new IllegalArgumentException("Число столбцов первой матрицы должно равняться числу строк второй");
        }
        Double[][] result = new Double[rows][other.getCols()];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += data[i][k].doubleValue() * other.get(k, j).doubleValue();
                }
                result[i][j] = sum;
            }
        }
        return new Matrix<>(result);
    }

    public Matrix<Double> multiplyByNumber(Number k) {
        Double[][] result = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j].doubleValue() * k.doubleValue();
            }
        }
        return new Matrix<>(result);
    }

    public Matrix<Double> transpose() {
        Double[][] result = new Double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = data[i][j].doubleValue();   // строки и столбцы меняются местами
            }
        }
        return new Matrix<>(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%8.2f", data[i][j].doubleValue()));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
