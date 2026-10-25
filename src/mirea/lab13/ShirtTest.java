package mirea.lab13;

public class ShirtTest {
    public static void main(String[] args) {
        String[] shirts = new String[11];
        shirts[0] = "S001,Black Polo Shirt,Black,XL";
        shirts[1] = "S002,Black Polo Shirt,Black,L";
        shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3] = "S004,Blue Polo Shirt,Blue,M";
        shirts[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirts[5] = "S006,Black T-Shirt,Black,XL";
        shirts[6] = "S007,White T-Shirt,White,XL";
        shirts[7] = "S008,White T-Shirt,White,L";
        shirts[8] = "S009,Green T-Shirt,Green,S";
        shirts[9] = "S010,Orange T-Shirt,Orange,S";
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";

        Shirt[] result = new Shirt[shirts.length];   // массив объектов Shirt
        for (int i = 0; i < shirts.length; i++) {
            String[] p = shirts[i].split(",");     // режем строку по запятым на 4 части
            result[i] = new Shirt(p[0], p[1], p[2], p[3]);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            System.out.println();                  // пустая строка между рубашками
        }
    }
}
