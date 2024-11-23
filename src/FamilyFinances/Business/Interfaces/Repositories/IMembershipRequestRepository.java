package FamilyFinances.Business.Interfaces.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateMembershipRequestEntityException;
import FamilyFinances.Business.Exceptions.MembershipRequestEntityNotFoundException;
import FamilyFinances.Domain.Constants.MembershipRequestStatusEnum;
import FamilyFinances.Domain.Models.MembershipRequest;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IMembershipRequestRepository {

    public MembershipRequest findById(Integer id) throws MembershipRequestEntityNotFoundException, Exception;

    public List<MembershipRequest> findByFamily(Integer familyId) throws MembershipRequestEntityNotFoundException, Exception;

    public List<MembershipRequest> findByMember(Integer memberId) throws MembershipRequestEntityNotFoundException, Exception;

    public List<MembershipRequest> findByMemberWhoApproved(Integer memberId) throws MembershipRequestEntityNotFoundException, Exception;
  
    public List<MembershipRequest> findByMemberWhoRejected(Integer memberId) throws MembershipRequestEntityNotFoundException, Exception;
   
    public List<MembershipRequest> findByStatus(MembershipRequestStatusEnum status) throws MembershipRequestEntityNotFoundException, Exception;
   
    public List<MembershipRequest> findByRequestDate(LocalDate requestDate) throws MembershipRequestEntityNotFoundException, Exception;
    
    public List<MembershipRequest> findByRequestDateBetween(LocalDate startDate, LocalDate endDate) throws MembershipRequestEntityNotFoundException, Exception;
   
    public List<MembershipRequest> findByApprovedDate(LocalDate approvedDate) throws MembershipRequestEntityNotFoundException, Exception;
    
    public List<MembershipRequest> findByApprovedDateBetween(LocalDate startDate, LocalDate endDate) throws MembershipRequestEntityNotFoundException, Exception;
    
    public List<MembershipRequest> findByRejectedDate(LocalDate rejectiondDate) throws MembershipRequestEntityNotFoundException, Exception;
    
    public List<MembershipRequest> findByRejectedDateBetween(LocalDate startDate, LocalDate endDate) throws MembershipRequestEntityNotFoundException, Exception;
    
    public List<MembershipRequest> findByReasonApproved(String reason) throws MembershipRequestEntityNotFoundException, Exception;
    
    public List<MembershipRequest> findByReasonRejected(String reason) throws MembershipRequestEntityNotFoundException, Exception;

    public List<MembershipRequest> getAll() throws MembershipRequestEntityNotFoundException, Exception;

    public MembershipRequest save(MembershipRequest membershipRequest) throws DuplicateMembershipRequestEntityException, Exception;

    public MembershipRequest edit(MembershipRequest membershipRequest) throws MembershipRequestEntityNotFoundException, Exception;

    public void deleteById(Integer id) throws MembershipRequestEntityNotFoundException, Exception;

}
