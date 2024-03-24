package com.flex.fibonacci;

import org.springframework.web.bind.annotation.GetMapping;

public class FibonacciController {

    @GetMapping("/current")
    public Integer current() {
        
        return null;
    }

    @GetMapping("/next")
    public Integer next() {
        
        return null;
    }

    @GetMapping("/previous")
    public Integer previous() {
        
        return null;
    }
}
