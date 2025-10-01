package CEA_Indiv.Application.UsesCAses;

import CEA_Indiv.Domain.Entitis.Aplicacion;
import CEA_Indiv.Domain.Repositorie.AplicacionRepositori;

public class CrearApli {
    private AplicacionRepositori repo;

    public CrearApli(AplicacionRepositori repo) {
        this.repo = repo;
    }

    public boolean ejecutar(Aplicacion aplicacion) {
        return repo.crearAplicacion(aplicacion);
    }


}
