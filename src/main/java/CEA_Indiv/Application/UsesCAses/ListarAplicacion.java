package CEA_Indiv.Application.UsesCAses;

import CEA_Indiv.Domain.Entitis.Aplicacion;
import CEA_Indiv.Domain.Repositorie.AplicacionRepositori;


public class ListarAplicacion {
    private AplicacionRepositori repo;

    public ListarAplicacion(AplicacionRepositori repo) {
         this.repo = repo;
    }

    public Aplicacion[] listarAplicaciones(){
        return repo.listarAplicaciones();
    }

}
