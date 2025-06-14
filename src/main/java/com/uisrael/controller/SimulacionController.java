
package com.uisrael.controller;

import com.uisrael.entity.Simulacion;
import com.uisrael.service.interfaces.SimulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class SimulacionController {

    @Autowired
    private SimulacionService simulacionService;

    // Mostrar formulario principal
    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("simulacion", new Simulacion());
        model.addAttribute("simulaciones", simulacionService.obtenerTodasLasSimulaciones());
        return "formulario";
    }

    // Calcular inversión
    @PostMapping("/calcular")
    public String procesarSimulacion(@ModelAttribute("simulacion") Simulacion simulacion, Model model) {
        try {
            Simulacion resultado = simulacionService.calcularSimulacion(simulacion);
            model.addAttribute("resultado", resultado); // Pasar resultado a resultado.html
            return "resultado"; // Redirige a resultado.html
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "formulario";
        }
    }
    @GetMapping("/resultado")
    public String mostrarResultado(@ModelAttribute Simulacion resultado, Model model) {
        model.addAttribute("resultado", resultado);
        return "resultado";
    }
    // Guardar simulación
    @PostMapping("/guardar")
    public String guardarSimulacion(@ModelAttribute Simulacion resultado, Model model) {
        simulacionService.guardarSimulacion(resultado);

        model.addAttribute("simulaciones", simulacionService.obtenerTodasLasSimulaciones());
        return "redirect:/";
    }
}