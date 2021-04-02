package br.com.crudteste.springcrudteste.utilidades;

import java.time.LocalDate;
import java.time.Period;

public final class Utilidades {

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}

