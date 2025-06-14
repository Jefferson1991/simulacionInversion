
package com.uisrael.service.interfaces;

import com.uisrael.entity.Simulacion;
import java.util.List;

public interface SimulacionService {
    Simulacion calcularSimulacion(Simulacion simulacion);
    void guardarSimulacion(Simulacion simulacion);
    List<Simulacion> obtenerTodasLasSimulaciones();
}