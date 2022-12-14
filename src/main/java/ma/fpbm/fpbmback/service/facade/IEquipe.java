package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Equipe;

import java.util.List;

public interface IEquipe {
    Equipe saveEquipe(Equipe equipe);

    List<Equipe> getAllEquipes();

    Equipe getEquipeById(Long idEquipe);

    Equipe updateEquipe(Equipe equipe);

    String deleteEquipe(Long equipeId);

}
