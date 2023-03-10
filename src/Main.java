import classes.Client;
import classes.Driver;
import classes.License;
import classes.Taxi;
import enums.Gender;
import enums.TaxiType;
import service.serviceImpl.ClientServiceImpl;
import service.serviceImpl.DriverImpl;

import java.awt.desktop.SystemEventListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        License license1 = new License(11L, LocalDate.of(2012, 2, 4), LocalDate.of(2022, 3, 4));
        License license2 = new License(12L, LocalDate.of(2013, 6, 1), LocalDate.of(2015, 3, 7));
        License license3 = new License(13L, LocalDate.of(2014, 5, 4), LocalDate.of(2020, 12, 30));
        Client client = new Client(1L, "Baiysh Orozaliev", LocalDate.of(2000, 1, 20), "+996552930920", BigDecimal.valueOf(80000));
        Client client1 = new Client(2L, "Davran Joldoshbaev", LocalDate.of(2004, 4, 12), "+996552930920", BigDecimal.valueOf(3000));
        Client client2 = new Client(3L, "Eliza Ashyrbaeva", LocalDate.of(2003, 3, 5), "+996552930920", BigDecimal.valueOf(5900));
        Client client3 = new Client(4L, "Kurstan Erkinbaev", LocalDate.of(2023, 7, 13), "+996552930920", BigDecimal.valueOf(25000));
        Taxi taxi1 = new Taxi(13L, "seaDv", "ds", "sdvds", LocalDate.ofYearDay(2004, 4), TaxiType.STANDART);
        Taxi taxi2 = new Taxi(1L, "Tayota", "777AA", "Red", LocalDate.of(2020, 1, 12), TaxiType.BUSINESS);
        Taxi taxi3 = new Taxi(2L, "KIA", "00OO", "Blue", LocalDate.of(2019, 12, 2), TaxiType.COMFORT);
        Taxi taxi4 = new Taxi(3L, "Fit", "888XX", "Red", LocalDate.of(2018, 1, 1), TaxiType.STANDART);
        Driver driver1 = new Driver(22L, "Eliza", "Ashyrbaeva", Gender.FEMALE, "+996225171735", null, new BigDecimal(35000),null);
        Driver driver2 = new Driver(23L, "Baiysh", "Orozaliev", Gender.MALE, "+996444455565", null, new BigDecimal(55000), null);
        Driver driver3 = new Driver(24L, "Davran", "Joldoshov", Gender.MALE, "+996225171735", null, new BigDecimal(65000), null);


        List<Driver> drivers = List.of(driver1, driver2, driver3);
        Set<Client> clients = new HashSet<>(Arrays.asList(client, client1, client2));

        DriverImpl driverImpl = new DriverImpl();
        while (true) {
            System.out.println("""
                    >>>>>>>>>>Drivers<<<<<<<<<<
                    1.Add driver->
                    2.Add Driver List->
                    3.Find By Id->
                    4.Find By Name->
                    5.Assign Taxi To Driver->
                    6.Get Driver By Taxi Model->
                    7.Update->
                    8.Change Taxi Or Driver
                    """);
            int number = new Scanner(System.in).nextInt();
            switch (number) {
                case 1 -> System.out.println(driverImpl.add(driver1));
                case 2 -> System.out.println(driverImpl.add(drivers));
                case 3 -> System.out.println(driverImpl.findById(new Scanner(System.in).nextLong()));
                case 4 -> System.out.println(driverImpl.findByName(new Scanner(System.in).nextLine()));
                case 5 -> System.out.println(driverImpl.assignTaxiToDriver(new Scanner(System.in).next(), new Scanner(System.in).nextLong()));
                case 6 -> System.out.println(driverImpl.getDriverByTaxiModel(new Scanner(System.in).nextLine()));
                case 7 -> driverImpl.update(new Scanner(System.in).next());
                case 8 -> System.out.println(driverImpl.changeTaxiOrDriver(new Scanner(System.in).nextLong(), new Scanner(System.in).nextLong()));
            }


        }
    }
}