package mirea.lab7.task1_3;

public class MovablePoint implements Movable {
    int x;                                         // без модификатора
    int y;
    int xSpeed;                                    // скорость по x
    int ySpeed;                                    // скорость по y

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";           // точка в виде строки
    }

    @Override
    public void moveUp() {
        y -= ySpeed;                               // как на экране компьютера: вверх значит y уменьшается
    }

    @Override
    public void moveDown() {
        y += ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }
}
