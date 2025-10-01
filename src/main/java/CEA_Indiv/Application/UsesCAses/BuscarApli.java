package CEA_Indiv.Application.UsesCAses;

import CEA_Indiv.Domain.Entitis.Aplicacion;
import CEA_Indiv.Domain.Repositorie.AplicacionRepositori;

public class BuscarApli {
    private AplicacionRepositori repo;

    public BuscarApli(AplicacionRepositori repo) {
        this.repo = repo;
    }

    public Aplicacion ejecutar(int id) {
        return repo.buscarAplicacion(id);
    }
}
