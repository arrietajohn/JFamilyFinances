package FamilyFinances.Business.UseCases.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByIdQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Families.IFindFamilyByIdQuery;
import FamilyFinances.Business.Interfaces.UseCases.Families.IGetFamilyService;
import FamilyFinances.Domain.Models.Family;

/**
 *
 * @author johnarrieta
 */
public class GetFamilyService implements IGetFamilyService{

    private final IFindFamilyByIdQuery findFamilyByIdQuery;

    public GetFamilyService(IFindFamilyByIdQuery findFamilyByIdQuery) {
        this.findFamilyByIdQuery = findFamilyByIdQuery;
    }
    
    @Override
    public Family getFamily(FindFamilyByIdQueryRequest request) throws Exception {
        return findFamilyByIdQuery.handler(request);
    }

}
