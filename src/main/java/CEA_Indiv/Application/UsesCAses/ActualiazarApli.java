package CEA_Indiv.Application.UsesCAses;

import CEA_Indiv.Domain.Entitis.Aplicacion;
import CEA_Indiv.Domain.Repositorie.AplicacionRepositori;

public class ActualiazarApli {
    private AplicacionRepositori repo;

    public ActualiazarApli(AplicacionRepositori repo) {
        this.repo = repo;
    }

    public boolean ejecutar(int id) {
        return repo.actualizarAplicacion(id);
    }
}
