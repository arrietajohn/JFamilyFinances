package FamilyFinances.Business.Interfaces.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateMemberEntityException;
import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Models.Member;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IMemberRepository {

    public Member findById(Integer id) throws MemberEntityNotFoundException, Exception;

    public List<Member>  findByFirstOrSecondName(String name) throws MemberEntityNotFoundException, Exception;
    
    public List<Member>  findByFirstLastOrSecondLastName(String lastName) throws MemberEntityNotFoundException, Exception;
    
    public List<Member>  findByGender(String gender) throws MemberEntityNotFoundException, Exception;
    
    public List<Member>  findByDateOfBirth(LocalDate dateOfBirth ) throws MemberEntityNotFoundException, Exception;
    
    public List<Member>  findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate ) throws MemberEntityNotFoundException, Exception;
   
    public List<Member>  findByOcupation(String ocupation ) throws MemberEntityNotFoundException, Exception;
  
    public List<Member>  findByFamilyRole(FamilyRoleEnum familyRole ) throws MemberEntityNotFoundException, Exception;
    
    public List<Member>  findByPhoneNumber(String phoneNumber ) throws MemberEntityNotFoundException, Exception;
    
    public List<Member>  findByFamilyId(Integer familyId ) throws MemberEntityNotFoundException, Exception;

    public List<Member> getAll() throws MemberEntityNotFoundException, Exception;

    public void save(Member role) throws DuplicateMemberEntityException, Exception;

    public void edit(Member role) throws MemberEntityNotFoundException, Exception;

    public void deleteById(Integer id) throws MemberEntityNotFoundException, Exception;


}
