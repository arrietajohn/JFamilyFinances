package FamilyFinances.Business.Handlers.Queries.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByIdQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Families.IFindFamilyByIdQuery;
import FamilyFinances.Business.Interfaces.Repositories.IFamilyRepository;
import FamilyFinances.Domain.Models.Family;

/**
 *
 * @author johnarrieta
 */
public class FindFamilyByIdQueryHandler implements IFindFamilyByIdQuery{

    private final IFamilyRepository familyRepository;

    public FindFamilyByIdQueryHandler(IFamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }
    
    
    @Override
    public Family handler(FindFamilyByIdQueryRequest request) throws Exception {
        return familyRepository.findById(request.getFamilyId());
    }

}
