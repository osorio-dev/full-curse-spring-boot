package br.com.dev.osorio.full_curse_spring_boot.controllers;

import br.com.dev.osorio.full_curse_spring_boot.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new ResourceNotFoundException("value invalid");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) {

        if (strNumber == null || strNumber.isEmpty()) throw new ResourceNotFoundException("value invalid");

        String number = strNumber.replace(',', '.');

        return Double.parseDouble(number);
    }

    private Boolean isNumeric(String strNumber) {

        if (strNumber == null || strNumber.isEmpty()) return false;

        String number = strNumber.replace(',', '.');
        return number.matches("[-+]?\\d*\\.?\\d+");
    }
}
