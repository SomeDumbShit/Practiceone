package mirea.lab13;

public class AddressTest {
    public static void main(String[] args) {
        String[] withCommas = {
            "Россия, Московская область, Москва, Ленина, 5, 2, 12",
            "Россия, Свердловская область, Екатеринбург, Мира, 10, , 45",
            "Беларусь, Минская область, Минск, Победителей, 7, 1, 33",
            "Россия,Татарстан,Казань,Баумана,3,,8"
        };
        String[] mixed = {
            "Россия; Московская область. Москва, Ленина; 5. 2, 12",
            "Россия. Свердловская область; Екатеринбург, Мира; 10, , 45",
            "Беларусь, Минская область; Минск. Победителей, 7; ; 33",
            "Россия, Татарстан, Казань"
        };

        System.out.println("Вариант а: split, только запятая");
        for (int i = 0; i < withCommas.length; i++) {
            System.out.println(Address.parseSplit(withCommas[i]));
        }

        System.out.println();
        System.out.println("Вариант б: StringTokenizer, разделители , . ;");
        for (int i = 0; i < mixed.length; i++) {
            Address address = Address.parseTokenizer(mixed[i]);
            if (address == null) {
                System.out.println("Неверный формат адреса: " + mixed[i]);
            } else {
                System.out.println(address);
            }
        }
    }
}
