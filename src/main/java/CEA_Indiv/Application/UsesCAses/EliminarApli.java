package CEA_Indiv.Application.UsesCAses;

import CEA_Indiv.Domain.Entitis.Aplicacion;
import CEA_Indiv.Domain.Repositorie.AplicacionRepositori;

public class EliminarApli {
    private AplicacionRepositori repo;

    public EliminarApli(AplicacionRepositori repo){
        this.repo = repo;
    }

    public boolean ejecutar(int id){
        return repo.eliminarAplicacion(id);
    }
}
