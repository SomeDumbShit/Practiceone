package mirea.lab13;

import java.util.StringTokenizer;

public class Address {
    private String country;                        // страна
    private String region;                         // регион
    private String city;                           // город
    private String street;                         // улица
    private String house;                          // дом
    private String building;                       // корпус
    private String flat;                           // квартира

    public Address(String country, String region, String city, String street,
                   String house, String building, String flat) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.building = building;
        this.flat = flat;
    }

    // вариант а: разделитель только запятая, используем split()
    public static Address parseSplit(String line) {
        String[] parts = line.split(",", -1);      // -1 значит не отбрасывать пустые части в конце
        if (parts.length != 7) {                   // в адресе должно быть ровно 7 частей
            return null;
        }
        return new Address(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(),
                parts[4].trim(), parts[5].trim(), parts[6].trim());   // trim убирает пробелы по краям
    }

    // вариант б: разделители , . ; используем StringTokenizer
    public static Address parseTokenizer(String line) {
        StringTokenizer st = new StringTokenizer(line, ",.;", true);   // true: разделители тоже приходят как токены
        String[] parts = new String[7];
        int count = 0;                             // сколько разделителей уже встретили
        String current = "";                       // часть адреса, которую сейчас собираем
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.length() == 1 && ",.;".indexOf(token) >= 0) {   // токен это разделитель
                if (count >= 6) {                  // разделителей больше 6, значит частей больше 7
                    return null;
                }
                parts[count] = current.trim();     // сохраняем собранную часть
                count++;
                current = "";                      // пустая часть остается пустой строкой (например, нет корпуса)
            } else {
                current = token;
            }
        }
        if (count != 6) {                          // должно быть ровно 6 разделителей
            return null;
        }
        parts[6] = current.trim();                 // последняя часть идет после последнего разделителя
        return new Address(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }

    @Override
    public String toString() {
        return "страна: " + country + ", регион: " + region + ", город: " + city + ", улица: " + street
                + ", дом: " + house + ", корпус: " + building + ", квартира: " + flat;
    }
}
