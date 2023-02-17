/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author esteb
 */
public class Validadores {

    public boolean validaNombre(String s) {
        String patron = "^(?=.{2,30}$)[A-Za-z]+(\\s[A-Za-z]+)?$";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    public boolean validaApellido(String s) {
        String patron = "^[a-zA-ZñÑ]{3,20}$";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    public boolean validaCorreo(String s) {
        String patron = "(\\w|[.'-]){1,25}[@]{1}(\\w|[.'-]){1,25}";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    public boolean validaContrasena(String s) {
        String patron = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#\\$%\\^&\\*])[a-zA-Z\\d!@#\\$%\\^&\\*]{8,16}$";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    public int validaEdad(Date fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fecha = fechaNacimiento.toLocalDate();
        Period periodo = Period.between(fechaActual, fecha);
        return Math.abs(periodo.getYears());
    }

    public boolean validaCalle(String s) {
        String patron = "^[A-Za-z0-9]{1,20}\\s*[,.]?\\s*[0-9]*\\s*(?:(?:[A-Za-z]+(?:\\s|[-']\\s)?)+|(?:[A-Za-z]+\\.?(?:\\s|[-']\\s)?)+|(?:[A-Za-z]+-?[A-Za-z]*(?:\\s|[-']\\s)?)+)$";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    public boolean validaColonia(String s) {
        String patron = "^[A-Za-z0-9]{1,20}\\s*[,.]?\\s*[0-9]*\\s*(?:(?:[A-Za-z]+(?:\\s|[-']\\s)?)+|(?:[A-Za-z]+\\.?(?:\\s|[-']\\s)?)+|(?:[A-Za-z]+-?[A-Za-z]*(?:\\s|[-']\\s)?)+)$";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    public boolean validaNumCasa(String s) {
        String patron = "^[A-Za-z0-9]{1,5}$";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }
}
