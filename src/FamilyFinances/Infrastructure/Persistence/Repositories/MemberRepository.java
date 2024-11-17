package FamilyFinances.Infrastructure.Persistence.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateMemberEntityException;
import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Commons.Helpers.EnumsHelper;
import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Models.Member;
import FamilyFinances.Infrastructure.Persistence.Data.InMemoryEntitiesStorage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class MemberRepository implements IMemberRepository {

    private final InMemoryEntitiesStorage memoryEntityStorage;

    public MemberRepository() {
        this.memoryEntityStorage = InMemoryEntitiesStorage.getInstance();
    }

    @Override
    public Member findById(Integer id) throws MemberEntityNotFoundException, Exception {
        return getMemberById(id);
    }

    @Override
    public List<Member> findByFirstOrSecondName(String name) throws MemberEntityNotFoundException, Exception {
        var targetName = name.toLowerCase();
        var membersResult = memoryEntityStorage.getMembers()
                .values()
                .stream()
                .filter(m -> m.getFirstName() != null
                && m.getFirstName().toLowerCase()
                        .contains(targetName)
                || m.getSecondName() != null
                && m.getSecondName().toLowerCase()
                        .contains(targetName))
                .toList();

        if (membersResult.isEmpty()) {
            throw new MemberEntityNotFoundException("No existen miembros con el nombre " + name);
        }
        return membersResult;
    }

    @Override
    public List<Member> findByFirstLastOrSecondLastName(String lastName) throws MemberEntityNotFoundException, Exception {
        var targetLastName = lastName.toLowerCase();
        var membersResult = memoryEntityStorage.getMembers()
                .values()
                .stream()
                .filter(m -> m.getFirstLastName() != null
                && m.getFirstLastName().toLowerCase()
                        .contains(targetLastName)
                || m.getSecondLastName() != null
                && m.getSecondLastName().toLowerCase()
                        .contains(targetLastName))
                .toList();

        if (membersResult.isEmpty()) {
            throw new MemberEntityNotFoundException("No existen miembros con el apellido " + lastName);
        }
        return membersResult;
    }

    @Override
    public List<Member> findByGender(String gender) throws MemberEntityNotFoundException, Exception {
        var membersResult = memoryEntityStorage.getMembers()
                .values()
                .stream()
                .filter(m -> m.getGender() != null
                && m.getGender().equalsIgnoreCase(gender))
                .toList();
        if (membersResult.isEmpty()) {
            throw new MemberEntityNotFoundException("No existen miembros con el genero " + gender);
        }
        return membersResult;
    }

    @Override
    public List<Member> findByDateOfBirth(LocalDate dateOfBirth) throws MemberEntityNotFoundException, Exception {
        var membersResult = memoryEntityStorage.getMembers()
                .values()
                .stream()
                .filter(m -> m.getDateOfBirth().equals(dateOfBirth)).toList();

        if (membersResult == null) {
            DateTimeFormatter latinDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            var errorMessage = "No existen miembros nacidos en  " + dateOfBirth.format(latinDateFormat);
            throw new MemberEntityNotFoundException(errorMessage);
        }
        return membersResult;
    }

    @Override
    public List<Member> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate) throws MemberEntityNotFoundException, Exception {
        var membersResult = memoryEntityStorage.getMembers()
                .values()
                .stream()
                .filter(m -> {
                    var dateOfBirth = m.getDateOfBirth();
                    return dateOfBirth != null
                            && !dateOfBirth.isBefore(startDate)
                            && !dateOfBirth.isAfter(endDate);
                }).toList();

        if (membersResult.isEmpty()) {
            DateTimeFormatter latinDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            var errorMessage = "No existen miembros nacidos entre   " + startDate.format(latinDateFormat) + " y " + endDate.format(latinDateFormat);
            throw new MemberEntityNotFoundException(errorMessage);
        }
        return membersResult;
    }

    @Override
    public List<Member> findByOcupation(String ocupation) throws MemberEntityNotFoundException, Exception {
        var membersResult = memoryEntityStorage.getMembers()
                .values()
                .stream()
                .filter(m -> m.getOccupation() != null
                && m.getOccupation().equalsIgnoreCase(ocupation)).toList();
        if (membersResult.isEmpty()) {
            throw new MemberEntityNotFoundException("No existen miembros con la ocupacion " + ocupation);
        }
        return membersResult;
    }

    @Override
    public List<Member> findByFamilyRole(FamilyRoleEnum familyRole) throws MemberEntityNotFoundException, Exception {
        var membersResult = memoryEntityStorage.getMembers()
                .values()
                .stream()
                .filter(m -> m.getFamilyRole() == familyRole)
                .toList();
        if (membersResult.isEmpty()) {
            var errorMessage = "No existen miembros con el rol " + EnumsHelper.getFamilyReleInSpanish(familyRole);
            throw new MemberEntityNotFoundException(errorMessage);
        }
        return membersResult;
    }

    @Override
    public List<Member> findByPhoneNumber(String phoneNumber) throws MemberEntityNotFoundException, Exception {
        var membersResult = memoryEntityStorage.getMembers()
                .values()
                .stream()
                .filter(m -> m.getCellPhoneNumber() != null
                && m.getCellPhoneNumber().equals(phoneNumber))
                .toList();
        if (membersResult.isEmpty()) {
            var errorMessage = "No existen miembros con el Telefono " + phoneNumber;
            throw new MemberEntityNotFoundException(errorMessage);
        }
        return membersResult;
    }

    @Override
    public List<Member> findByFamilyId(Integer familyId) throws MemberEntityNotFoundException, Exception {
        var membersResult = memoryEntityStorage.getMembers()
                .values()
                .stream()
                .filter(m -> m.getFamily() != null
                && m.getFamily().getId() == familyId)
                .toList();
        if (membersResult.isEmpty()) {
            var errorMessage = "No existen miembros en la Familia Id: " + familyId;
            throw new MemberEntityNotFoundException(errorMessage);
        }
        return membersResult;
    }

    @Override
    public List<Member> getAll() throws MemberEntityNotFoundException, Exception {
        var membersResult = memoryEntityStorage.getMembers()
                .values()
                .stream()
                .toList();
        if (membersResult.isEmpty()) {
            var errorMessage = "No existen miembros disponibles";
            throw new MemberEntityNotFoundException(errorMessage);
        }
        return membersResult;
    }

    @Override
    public void save(Member member) throws DuplicateMemberEntityException, Exception {
        if (member == null) {
            throw new IllegalAccessException("El miembro es requerido");
        }
        if (member.getId() == null) {
            throw new IllegalAccessException("El Id del miembro es requerido");
        }
        if (existMember(member.getId())) {
            throw new DuplicateMemberEntityException("El miembro ya existe");
        }
        if (member.getFamily() == null) {
            throw new IllegalAccessException("La familia del miembro es requerida");
        }
       
        
        
        memoryEntityStorage.getMembers().put(member.getId(), member);
    }

    @Override
    public void edit(Member member) throws MemberEntityNotFoundException, Exception {
        if (member == null) {
            throw new IllegalAccessException("El miembro es requerido");
        }
        if (member.getFamily() == null) {
            throw new IllegalAccessException("La familia del miembro es requerida");
        }

        if (!existMember(member.getId())) {
            throw new DuplicateMemberEntityException("El miembro no existe");
        }

        memoryEntityStorage.getMembers().replace(member.getId(), member);
    }

    @Override
    public void deleteById(Integer id) throws MemberEntityNotFoundException, Exception {
        if (id < 1) {
            throw new IllegalAccessException("El id " + id + " del miembro no es valido");
        }

        if (!existMember(id)) {
            throw new DuplicateMemberEntityException("El miembro Id " + id + " no existe");
        }

        memoryEntityStorage.getMembers().remove(id);
    }

    private Member getMemberById(Integer id) throws MemberEntityNotFoundException, Exception {
        var memberFound = memoryEntityStorage.getMembers().get(id);
        if (memberFound == null) {
            throw new MemberEntityNotFoundException("El miembro con Id: " + id + " no existe");
        }
        return memberFound;
    }

    private boolean existMember(Integer id) {
        return memoryEntityStorage.getMembers().containsKey(id);
    }

}
