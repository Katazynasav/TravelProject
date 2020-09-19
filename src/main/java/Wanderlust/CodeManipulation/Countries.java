package Wanderlust.CodeManipulation;

import java.util.*;

public class Countries {

    public List<String> countriesList = new ArrayList<>();

    public void listOfCountries() {
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes) {
            Locale obj = new Locale("", countryCode);
            countriesList.add(obj.getDisplayCountry());
        }
        // System.out.println(countriesList.toString());

        //     List<String> userCountries = new ArrayList<>();
        //     Scanner scan = new Scanner(System.in);
        //     String country = scan.next();
        //     for (String s : countriesList) {
        //         if (s.equals(country)) {
        //             userCountries.add(s);
        //         }
        //     }
        //     System.out.println(userCountries.toString());
        //

    }


    public String randomCountry() {
        Countries countries = new Countries();
        countries.listOfCountries();
        Random random = new Random();
        int randomCountry = random.nextInt(countries.countriesList.size());
        String country = countries.countriesList.get(randomCountry);
        return country;
    }
}

