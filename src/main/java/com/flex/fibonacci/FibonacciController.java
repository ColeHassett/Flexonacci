package com.flex.fibonacci;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    public Integer index = 0;
    public Double value = 0.0;

    // Phi A.K.A. Golden Value, used in calculating Fibonacci sequence at a given index
    public static final Double phi = (1 + Math.sqrt(5)) / 2;

    @GetMapping("/current")
    public Double current() { return value; }

    @GetMapping("/next")
    public Double next() {
        index += 1;
        return calcValue();
    }

    @GetMapping("/previous")
    public Double previous() {
        if (index > 0) {
            index -= 1;
        }
        return calcValue();
    }

    /**
     * Calculate and return the Fibonacci sequence value at the current index
     * 
     * @return Fibonacci sequence value at current index
     */
    private Double calcValue() {
        value = Math.rint((Math.pow(phi, index) - Math.pow((1-phi), index)) / Math.sqrt(5));
        return value;
    }
}
