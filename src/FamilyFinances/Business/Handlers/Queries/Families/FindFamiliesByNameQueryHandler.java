package FamilyFinances.Business.Handlers.Queries.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByNameQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Families.IFindFamiliesByNameQuery;
import FamilyFinances.Business.Interfaces.Repositories.IFamilyRepository;
import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class FindFamiliesByNameQueryHandler implements IFindFamiliesByNameQuery{

    private final IFamilyRepository familyRepository;

    public FindFamiliesByNameQueryHandler(IFamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public List<Family> handler(FindFamilyByNameQueryRequest request) throws Exception {
        return familyRepository.findByName(request.getFamilyName());
    }
}
