package FamilyFinances.Business.UseCases.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByNameQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Families.IFindFamiliesByNameQuery;
import FamilyFinances.Business.Interfaces.Queries.Families.IGetAllFamiliesQuery;
import FamilyFinances.Business.Interfaces.UseCases.Families.IGetFamiliesService;
import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class GetFamiliesService implements IGetFamiliesService{

    private final IFindFamiliesByNameQuery getFamiliesByNameQuery;
    private final IGetAllFamiliesQuery getAllFamiliesQuery;

    public GetFamiliesService(IFindFamiliesByNameQuery getFamiliesByNameQuery, IGetAllFamiliesQuery getAllFamiliesQuery) {
        this.getFamiliesByNameQuery = getFamiliesByNameQuery;
        this.getAllFamiliesQuery = getAllFamiliesQuery;
    }
    
    
    @Override
    public List<Family> getFamilies(FindFamilyByNameQueryRequest request) throws Exception {
        return  getFamiliesByNameQuery.handler(request);
    }

    @Override
    public List<Family> getFamilies() throws Exception {
        return getAllFamiliesQuery.handler();
    }

   

}
