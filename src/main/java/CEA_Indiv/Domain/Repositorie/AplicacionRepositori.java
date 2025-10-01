package CEA_Indiv.Domain.Repositorie;

import CEA_Indiv.Domain.Entitis.Aplicacion;

public interface AplicacionRepositori {
    boolean crearAplicacion(Aplicacion aplicacion);
    boolean eliminarAplicacion(Aplicacion aplicacion);
    boolean actualizarAplicacion(Aplicacion aplicacion);
    Aplicacion buscarAplicacion(String nombre);
    Aplicacion[] listarAplicaciones();


}
