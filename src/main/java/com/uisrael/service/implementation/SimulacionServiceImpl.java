
package com.uisrael.service.implementation;

import com.uisrael.entity.Simulacion;
import com.uisrael.repository.SimulacionRepository;
import com.uisrael.service.interfaces.SimulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SimulacionServiceImpl implements SimulacionService {

    @Autowired
    private SimulacionRepository simulacionRepository;

    @Override
    public Simulacion calcularSimulacion(Simulacion simulacion) {
        if (simulacion.getCapitalInicial() <= 100) {
            throw new IllegalArgumentException("El capital inicial debe ser superior a 100 USD.");
        }

        // Asignar tasa según periodos
        switch (simulacion.getNumeroPeriodos()) {
            case 12 -> simulacion.setTasaInteres(0.11); // Mensual
            case 4 -> simulacion.setTasaInteres(0.07);  // Trimestral
            case 2 -> simulacion.setTasaInteres(0.05);  // Semestral

            default -> throw new IllegalArgumentException("Número de periodos no válido.");
        }

        // Fórmula del interés compuesto
        double montoFinal = simulacion.getCapitalInicial() *
                Math.pow((1 + simulacion.getTasaInteres() / simulacion.getNumeroPeriodos()),
                        simulacion.getNumeroPeriodos() * simulacion.getTiempoAnios());
        double interesGanado = montoFinal - simulacion.getCapitalInicial();

        // Redondear a 2 decimales
        montoFinal = BigDecimal.valueOf(montoFinal).setScale(2, RoundingMode.HALF_UP).doubleValue();
        interesGanado = BigDecimal.valueOf(interesGanado).setScale(2, RoundingMode.HALF_UP).doubleValue();

        simulacion.setMontoFinal(montoFinal);
        simulacion.setInteresGanado(interesGanado);

        double capital = simulacion.getCapitalInicial();
        int periodos = simulacion.getNumeroPeriodos();

        // Categorización
        if (periodos == 12) {
            if (capital > 1000) {
                simulacion.setCategoria("Categoría 1");
            } else if (capital >= 501 && capital <= 1000) {
                simulacion.setCategoria("Categoría 2");
            } else if (capital >= 100 && capital <= 500) {
                simulacion.setCategoria("Categoría 3");
            } else {
                simulacion.setCategoria("Sin categoría"); // Capital menor a 100
            }
        } else {
            simulacion.setCategoria("Sin categoría");
        }

        simulacion.setFechaSimulacion(LocalDateTime.now());

        return simulacion;
    }

    @Override
    public void guardarSimulacion(Simulacion simulacion) {
        simulacion.setFechaSimulacion(LocalDateTime.now());
        simulacionRepository.save(simulacion);
    }

    @Override
    public List<Simulacion> obtenerTodasLasSimulaciones() {
        return simulacionRepository.findAll();
    }
}