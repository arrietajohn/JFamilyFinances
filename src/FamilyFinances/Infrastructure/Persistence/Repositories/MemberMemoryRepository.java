package FamilyFinances.Infrastructure.Persistence.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateMemberEntityException;
import FamilyFinances.Business.Exceptions.DuplicateMembershipRequestEntityException;
import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Business.Interfaces.Repositories.IMembershipRequestRepository;
import FamilyFinances.Commons.Helpers.EnumsHelper;
import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Constants.MembershipRequestStatusEnum;
import FamilyFinances.Domain.Models.Member;
import FamilyFinances.Domain.Models.MembershipRequest;
import FamilyFinances.Infrastructure.Persistence.Data.InMemoryEntitiesStorage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author johnarrieta
 */
public class MemberMemoryRepository implements IMemberRepository {

    private final InMemoryEntitiesStorage memoryEntityStorage;
    private final IMembershipRequestRepository membershipRequestRepository;

    public MemberMemoryRepository(IMembershipRequestRepository membershipRequestRepository) {
        this.memoryEntityStorage = InMemoryEntitiesStorage.getInstance();
        this.membershipRequestRepository = membershipRequestRepository;
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
    public void save(Member newMember) throws DuplicateMemberEntityException, Exception {
        if (newMember == null) {
            throw new IllegalArgumentException("El miembro es requerido");
        }
        if (newMember.getId() == null) {
            throw new IllegalArgumentException("El Id del miembro es requerido");
        }
        if (existMember(newMember.getId())) {
            throw new DuplicateMemberEntityException("El miembro ya existe");
        }
        if (newMember.getFamily() == null) {
            throw new IllegalArgumentException("La familia del miembro es requerida");
        }
        memoryEntityStorage.getMembers().put(newMember.getId(), newMember);
        createMembershipRequest(newMember);
    }

    @Override
    public Member edit(Member member) throws MemberEntityNotFoundException, Exception {
        if (member == null) {
            throw new IllegalArgumentException("El miembro es requerido");
        }

        if (member.getId() == null || member.getId() < 1) {
            throw new IllegalArgumentException("El Id del Usaurio padre es requerido");
        }

        var currentMember = memoryEntityStorage.getMembers().get(member.getId());
        if (currentMember == null) {
            throw new IllegalArgumentException("El usuario  el usuario con id: " + member.getId());
        }
        currentMember.setStatus(member.getStatus());
        currentMember.setFirstName(member.getFirstName());
        currentMember.setSecondName(member.getSecondName());
        currentMember.setFirstLastName(member.getFirstLastName());
        currentMember.setSecondLastName(member.getSecondLastName());
        currentMember.setGender(member.getGender());
        currentMember.setDateOfBirth(member.getDateOfBirth());
        currentMember.setOccupation(member.getOccupation());
        currentMember.setCellPhoneNumber(member.getCellPhoneNumber());
        currentMember.setFamilyRole(member.getFamilyRole());
        if (member.getFamily() != null) {
            currentMember.setFamily(member.getFamily());
        }
        currentMember.setUpdateBy(member.getUpdateBy());
        currentMember.setUpdateDate(member.getUpdateDate());
        // No es necesario porque al cambiar los valores de la instancia
        // currentUser en realidad se esta cambiando lso datatos de la misma instancia
        // obtenida del storage
        return memoryEntityStorage.getMembers().replace(member.getId(), currentMember);

    }

    @Override
    public void deleteById(Integer id) throws MemberEntityNotFoundException, DuplicateMembershipRequestEntityException, Exception {
        if (id < 1) {
            throw new IllegalArgumentException("El id " + id + " del miembro no es valido");
        }

        var currentMember = memoryEntityStorage.getMembers().get(id);
        if (currentMember == null) {
            throw new DuplicateMemberEntityException("El miembro Id " + id + " no existe");
        }

        if (currentMember.getIncomes() != null && !currentMember.getIncomes().isEmpty()) {
            throw new DuplicateMemberEntityException("El miembro: " + id + " tiene ingresos registrados");
        }

        if (currentMember.getExpenses() != null && !currentMember.getExpenses().isEmpty()) {
            throw new DuplicateMemberEntityException("El miembro: " + id + " tiene gastos  registrados");
        }
        if (!currentMember.getMembershipRequests().isEmpty()) {
            var newmemberships = currentMember.getFamily().getMembershipRequests()
                    .stream()
                    .filter(mbs -> !mbs.getMember().equals(currentMember))
                    .collect(Collectors.toSet());
            currentMember.getFamily().setMembershipRequests(newmemberships);
        }
        currentMember.setFamily(null);
        currentMember.getCreatedBy().setMember(null);
        currentMember.getMembershipRequests().clear();
        memoryEntityStorage.getMembershipRequests()
                .entrySet()
                .removeIf(entry -> entry.getValue().getMember().equals(currentMember));
        memoryEntityStorage.getMembers()
                .entrySet()
                .removeIf(entry -> entry.getValue().equals(currentMember));
    }
    
        @Override
    public List<Member> findByStatus(MembershipRequestStatusEnum status) throws MemberEntityNotFoundException, Exception {
        if(status == null){
             throw new IllegalArgumentException("El estado del miembro es requerido");
        }
        var membsrshipRequest = membershipRequestRepository.findByStatus(status);
        var members = membsrshipRequest.stream()
                .filter(membership -> membership.getStatus() == status)
                .map(membership -> membership.getMember())
                .toList();
        if(members.isEmpty()){
            var message = "No existen miembros con estato: "+status.toSpanish();
            throw new MemberEntityNotFoundException(message);
        }
        return members;
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

    private void createMembershipRequest(Member newMember) throws DuplicateMembershipRequestEntityException, Exception {
        var familyRoleInSpanish = EnumsHelper.getFamilyReleInSpanish(newMember.getFamilyRole());
        var reason = "Soy " + familyRoleInSpanish + " de esta bella familia";
        var newMembershipRequest = new MembershipRequest(
                null,
                LocalDateTime.now(),
                MembershipRequestStatusEnum.PENDING,
                newMember,
                newMember.getFamily(),
                reason);
        membershipRequestRepository.save(newMembershipRequest);
        newMember.getMembershipRequests().add(newMembershipRequest);
        newMember.getFamily().getMembershipRequests().add(newMembershipRequest);
    }


}
