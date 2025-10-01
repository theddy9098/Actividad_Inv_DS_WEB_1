package CEA_Indiv.Domain.Repositorie;

import CEA_Indiv.Domain.Entitis.Aplicacion;

public interface AplicacionRepositori {
    boolean crearAplicacion(Aplicacion aplicacion);
    boolean eliminarAplicacion(int id );
    boolean actualizarAplicacion( Aplicacion aplicacion);
    Aplicacion buscarAplicacion(int id);
    Aplicacion[] listarAplicaciones();


}
