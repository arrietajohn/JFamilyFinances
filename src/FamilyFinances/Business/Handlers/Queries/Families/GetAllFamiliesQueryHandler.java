package FamilyFinances.Business.Handlers.Queries.Families;

import FamilyFinances.Business.Interfaces.Queries.Families.IGetAllFamiliesQuery;
import FamilyFinances.Business.Interfaces.Repositories.IFamilyRepository;
import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class GetAllFamiliesQueryHandler implements IGetAllFamiliesQuery{

    private final IFamilyRepository familyRepository;

    public GetAllFamiliesQueryHandler(IFamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public List<Family> handler() throws Exception {
        return familyRepository.getAll();
    }

}
