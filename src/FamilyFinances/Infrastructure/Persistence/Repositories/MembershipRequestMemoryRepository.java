package FamilyFinances.Infrastructure.Persistence.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateMembershipRequestEntityException;
import FamilyFinances.Business.Exceptions.FamilyEntityNotFoundException;
import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Exceptions.MembershipRequestEntityNotFoundException;
import FamilyFinances.Business.Exceptions.MembershipRequestWithCommentsExcepcion;
import FamilyFinances.Business.Interfaces.Repositories.IMembershipRequestRepository;
import FamilyFinances.Domain.Constants.MembershipRequestStatusEnum;
import FamilyFinances.Domain.Models.MembershipRequest;
import FamilyFinances.Infrastructure.Persistence.Data.InMemoryEntitiesStorage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class MembershipRequestMemoryRepository implements IMembershipRequestRepository {

    private final InMemoryEntitiesStorage memoryEntityStorage;

    public MembershipRequestMemoryRepository( ) {
        this.memoryEntityStorage = InMemoryEntitiesStorage.getInstance();
    }

    @Override
    public MembershipRequest findById(Integer id)
            throws MembershipRequestEntityNotFoundException, Exception {
        return getById(id);
    }

    @Override
    public List<MembershipRequest> findByFamily(Integer familyId)
            throws FamilyEntityNotFoundException, MembershipRequestEntityNotFoundException,
            IllegalAccessException, Exception {
        if (familyId == null || familyId < 1) {
            throw new IllegalAccessException("El Id de la familia es requerido");
        }

        var membershipRequests = memoryEntityStorage.getMembershipRequests().values()
                .stream()
                .filter(m -> m.getFamily().getId() == familyId).toList();
        if (membershipRequests.isEmpty()) {
            var errorMessage = "No existen solicitudes para la familia Id: " + familyId;
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }

        return membershipRequests;
    }

    @Override
    public List<MembershipRequest> findByMember(Integer memberId)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (memberId == null || memberId < 1) {
            throw new IllegalAccessException("El Id del miembro es requerido");
        }
        var mesbershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> membership.getMember().getId() == memberId)
                .toList();
        if (mesbershipRequests.isEmpty()) {
            var errorMessage = "No existen solicitudes para el miembro Id: " + memberId;
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return mesbershipRequests;
    }

    @Override
    public List<MembershipRequest> findByMemberWhoApproved(Integer memberId)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (memberId == null || memberId < 1) {
            throw new IllegalAccessException("El Id del miembro es requerido");
        }
        var mesbershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> membership.getApprovedBy().getId() == memberId)
                .toList();
        if (mesbershipRequests.isEmpty()) {
            var errorMessage = "No existen solicitudes aprobadas por el miembro Id: " + memberId;
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return mesbershipRequests;
    }

    @Override
    public List<MembershipRequest> findByMemberWhoRejected(Integer memberId)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (memberId == null || memberId < 1) {
            throw new IllegalAccessException("El Id del miembro es requerido");
        }
        var mesbershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> membership.getRejectedBy().getId() == memberId)
                .toList();
        if (mesbershipRequests.isEmpty()) {
            var errorMessage = "No existen solicitudes rechazadas por el miembro Id: " + memberId;
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return mesbershipRequests;
    }

    @Override
    public List<MembershipRequest> findByStatus(MembershipRequestStatusEnum status)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (status == null) {
            throw new IllegalAccessException("El Estado del la solicitud es requerido");
        }
        var mesbershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> membership.getStatus() == status)
                .toList();
        if (mesbershipRequests.isEmpty()) {
            var errorMessage = "No existen solicitudes con el stado " + status.toSpanish();
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return mesbershipRequests;
    }

    @Override
    public List<MembershipRequest> findByRequestDate(LocalDate requestDate)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (requestDate == null) {
            throw new IllegalAccessException("La fecha de la solicitud es requerida");
        }
        var mesbershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> membership.getRequestDate().toLocalDate().equals(requestDate))
                .toList();
        if (mesbershipRequests.isEmpty()) {
            var latinFormatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            var errorMessage = "No existen solicitudes realizadas el " + requestDate.format(latinFormatDate);
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return mesbershipRequests;
    }

    @Override
    public List<MembershipRequest> findByRequestDateBetween(LocalDate startDate, LocalDate endDate)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (startDate == null) {
            throw new IllegalAccessException("La fecha de inicio  es requerida");
        }

        if (startDate == null) {
            throw new IllegalAccessException("La fecha de fin  es requerida");
        }

        if (startDate.isAfter(endDate)) {
            throw new IllegalAccessException("Fechas e inicio y fin en rango incorrecto");
        }

        var mesbershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> !membership.getApprovedDate()
                .toLocalDate()
                .isBefore(startDate)
                && !membership.getApprovedDate()
                        .toLocalDate()
                        .isAfter(endDate))
                .toList();
        if (mesbershipRequests.isEmpty()) {
            var latinFormatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            var errorMessage = "No existen solicitudes entre ";
            errorMessage += startDate.format(latinFormatDate) + " y " + endDate.format(latinFormatDate);
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return mesbershipRequests;
    }

    @Override
    public List<MembershipRequest> findByApprovedDate(LocalDate approvedDate)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (approvedDate == null) {
            throw new IllegalAccessException("La fecha de aprobación de la solicitud es requerida");
        }
        var mesbershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> membership.getApprovedDate().toLocalDate().equals(approvedDate))
                .toList();
        if (mesbershipRequests.isEmpty()) {
            var latinFormatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            var errorMessage = "No existen solicitudes aprobadas el " + approvedDate.format(latinFormatDate);
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return mesbershipRequests;
    }

    @Override
    public List<MembershipRequest> findByApprovedDateBetween(LocalDate startDate, LocalDate endDate) throws MembershipRequestEntityNotFoundException, Exception {
        if (startDate == null) {
            throw new IllegalAccessException("La fecha de inicio  es requerida");
        }

        if (startDate == null) {
            throw new IllegalAccessException("La fecha de fin  es requerida");
        }

        if (startDate.isAfter(endDate)) {
            throw new IllegalAccessException("Fechas e inicio y fin en rango incorrecto");
        }

        var mesbershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> !membership.getApprovedDate()
                .toLocalDate()
                .isBefore(startDate)
                && !membership.getApprovedDate()
                        .toLocalDate()
                        .isAfter(endDate))
                .toList();
        if (mesbershipRequests.isEmpty()) {
            var latinFormatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            var errorMessage = "No existen solicitudes aprobadas entre ";
            errorMessage += startDate.format(latinFormatDate) + " y " + endDate.format(latinFormatDate);
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return mesbershipRequests;
    }

    @Override
    public List<MembershipRequest> findByRejectedDate(LocalDate rejectionDate)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (rejectionDate == null) {
            throw new IllegalAccessException("La fecha de rechazo de la solicitud es requerida");
        }
        var mesbershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> membership.getRejectionDate().toLocalDate().equals(rejectionDate))
                .toList();
        if (mesbershipRequests.isEmpty()) {
            var latinFormatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            var errorMessage = "No existen solicitudes rechazadas el " + rejectionDate.format(latinFormatDate);
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return mesbershipRequests;
    }

    @Override
    public List<MembershipRequest> findByRejectedDateBetween(LocalDate startDate, LocalDate endDate)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (startDate == null) {
            throw new IllegalAccessException("La fecha de inicio  es requerida");
        }

        if (startDate == null) {
            throw new IllegalAccessException("La fecha de fin  es requerida");
        }

        if (startDate.isAfter(endDate)) {
            throw new IllegalAccessException("Fechas e inicio y fin en rango incorrecto");
        }

        var mesbershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> !membership.getRejectionDate()
                .toLocalDate()
                .isBefore(startDate)
                && !membership.getRejectionDate()
                        .toLocalDate()
                        .isAfter(endDate))
                .toList();
        if (mesbershipRequests.isEmpty()) {
            var latinFormatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            var errorMessage = "No existen solicitudes rechazadas entre ";
            errorMessage += startDate.format(latinFormatDate) + " y " + endDate.format(latinFormatDate);
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return mesbershipRequests;
    }

    @Override
    public List<MembershipRequest> findByReasonApproved(String reason)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (reason == null || reason.isBlank()) {
            throw new IllegalAccessException("El motivo es requerido");
        }
        var membershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> membership.getReasonApproved() != null
                && membership.getReasonApproved().contains(reason))
                .toList();
        if (membershipRequests.isEmpty()) {
            var errorMessage = "No existen solicitudes con motivos de aprobacion que contengan \"" + reason + "\"";
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return membershipRequests;
    }

    @Override
    public List<MembershipRequest> findByReasonRejected(String reason)
            throws MembershipRequestEntityNotFoundException, Exception {
        if (reason == null || reason.isBlank()) {
            throw new IllegalAccessException("El motivo es requerido");
        }
        var membershipRequests = memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .filter(membership -> membership.getReasonRejected() != null
                && membership.getReasonRejected().contains(reason))
                .toList();
        if (membershipRequests.isEmpty()) {
            var errorMessage = "No existen solicitudes con motivos de rechazo que contengan \"" + reason + "\"";
            throw new MembershipRequestEntityNotFoundException(errorMessage);
        }
        return membershipRequests;

    }

    @Override
    public List<MembershipRequest> getAll() throws MembershipRequestEntityNotFoundException, Exception {

        var membershipRequests = memoryEntityStorage.getMembershipRequests().values().stream().toList();
        if (membershipRequests.isEmpty()) {
            throw new MembershipRequestEntityNotFoundException("No existen solicitudes disponibles en el sistema");
        }
        return membershipRequests;
    }

    @Override
    public MembershipRequest save(MembershipRequest newMembershipRequest) throws DuplicateMembershipRequestEntityException, Exception {
        if (newMembershipRequest == null) {
            throw new IllegalArgumentException("La solicitud es requerida");
        }

        if (newMembershipRequest.getFamily() == null) {
            throw new IllegalArgumentException("La familia de la solicitud es requerida");
        }

        if (newMembershipRequest.getFamily().getId() == null || newMembershipRequest.getFamily().getId() < 1) {
            throw new IllegalArgumentException("La el Id de familia de la solicitud es requerido");
        }

        if (newMembershipRequest.getMember() == null) {
            throw new IllegalArgumentException("El miembro de la solicitud es requerido");
        }

        if (newMembershipRequest.getMember().getId() == null || newMembershipRequest.getMember().getId() < 1) {
            throw new IllegalArgumentException("La el Id del solicitante es requerido");
        }

        if (newMembershipRequest.getRequestDate() == null) {
            newMembershipRequest.setRequestDate(LocalDateTime.now());
        }

        newMembershipRequest.setId(getNextId());

        if (exists(newMembershipRequest.getId())) {
            var errorMessage = "Ya existe una solicitud con Id: " + newMembershipRequest.getId();
            throw new DuplicateMembershipRequestEntityException(errorMessage);
        }

        newMembershipRequest.setMember(newMembershipRequest.getMember());
        newMembershipRequest.setFamily(newMembershipRequest.getFamily());
        newMembershipRequest.setStatus(MembershipRequestStatusEnum.PENDING);
        return memoryEntityStorage.getMembershipRequests()
                .put(newMembershipRequest.getId(), newMembershipRequest);
    }

    @Override
    public MembershipRequest edit(MembershipRequest updateMembershipRequest)
            throws MembershipRequestEntityNotFoundException, FamilyEntityNotFoundException,
            MemberEntityNotFoundException, Exception {

        if (updateMembershipRequest == null) {
            throw new IllegalArgumentException("La solicitud es requerida");
        }

        if (updateMembershipRequest.getId() == null || updateMembershipRequest.getId() < 1) {
            throw new IllegalArgumentException("El Id de la solicitud es requerido");
        }

        var membershipFound = getById(updateMembershipRequest.getId());

        if (updateMembershipRequest.getMember() == null) {
            throw new IllegalArgumentException("El miembro de la solicitud es requerido");
        }

        if (updateMembershipRequest.getMember().getId() == null || updateMembershipRequest.getMember().getId() < 1) {
            throw new IllegalArgumentException("El Id del solicitante es requerido");
        }

        var requestingMember = updateMembershipRequest.getMember();
        var currentMember = membershipFound.getMember();

        if (requestingMember.getId() != currentMember.getId()) {
            var message = "El miembro solicitante no coincide con el solicitante original";
            throw new IllegalArgumentException(message);
        }

        if (updateMembershipRequest.getFamily() == null) {
            throw new IllegalArgumentException("La familia de la solicitud es requerida");
        }

        if (updateMembershipRequest.getFamily().getId() == null || updateMembershipRequest.getFamily().getId() < 1) {
            throw new IllegalArgumentException("El Id de la familia es requerido");
        }

        var newFamily = updateMembershipRequest.getFamily();
        var currentFamily = membershipFound.getFamily();

        if (currentFamily != newFamily) {
            var message = "La familia solicitada no coincide con la original";
            throw new IllegalArgumentException(message);
        }

        if (updateMembershipRequest.getStatus() == null) {
            throw new IllegalArgumentException("El estado de la solicitud es requerido ");
        }

        if (updateMembershipRequest.getStatus() == MembershipRequestStatusEnum.PENDING) {
            var correctStatesMessage = MembershipRequestStatusEnum.fromEnglish(MembershipRequestStatusEnum.APPROVED);
            correctStatesMessage += " o " + MembershipRequestStatusEnum.fromEnglish(MembershipRequestStatusEnum.REJECTED);
            throw new IllegalArgumentException(correctStatesMessage);
        }

        if (updateMembershipRequest.getStatus() == MembershipRequestStatusEnum.APPROVED
                && (updateMembershipRequest.getApprovedBy() == null
                || updateMembershipRequest.getApprovedBy().getId() < 1)) {
             throw new IllegalArgumentException("El miembro que aprueba es requerido");
        }
        
        if (updateMembershipRequest.getStatus() == MembershipRequestStatusEnum.REJECTED
                && (updateMembershipRequest.getRejectedBy()== null
                || updateMembershipRequest.getRejectedBy().getId() < 1)) {
             throw new IllegalArgumentException("El miembro que rechaza es requerido");
        }
       
      if (updateMembershipRequest.getStatus() == MembershipRequestStatusEnum.APPROVED){
            membershipFound.setStatus(MembershipRequestStatusEnum.APPROVED);
            membershipFound.setApprovedBy(updateMembershipRequest.getApprovedBy());
            membershipFound.setReasonApproved(updateMembershipRequest.getReasonApproved());
            currentMember.setFamily(currentFamily);
            currentFamily.getMembers().add(currentMember);
            if (updateMembershipRequest.getApprovedDate() == null) {
                updateMembershipRequest.setApprovedDate(LocalDateTime.now());
            }
            membershipFound.setApprovedDate(updateMembershipRequest.getApprovedDate());
            return membershipFound;
        }

      if (updateMembershipRequest.getStatus() == MembershipRequestStatusEnum.REJECTED){
            membershipFound.setStatus(MembershipRequestStatusEnum.REJECTED);
            membershipFound.setRejectedBy(updateMembershipRequest.getRejectedBy());
            membershipFound.setReasonRejected(updateMembershipRequest.getReasonRejected());
            currentMember.setFamily(currentFamily);
            currentFamily.getMembers().remove(currentMember);
            if (updateMembershipRequest.getRejectionDate() == null) {
                updateMembershipRequest.setRejectionDate(LocalDateTime.now());
            }
            membershipFound.setRejectionDate(updateMembershipRequest.getRejectionDate());
            return membershipFound;
        }

        return membershipFound;
    }

    @Override
    public void deleteById(Integer id) throws MembershipRequestEntityNotFoundException, Exception {
        if (id == null || id < 1) {
            throw new IllegalArgumentException("El Id de la solicitud es requedido");
        }

        var currentMembersipRequest = findById(id);
        if (!currentMembersipRequest.getComments().isEmpty()) {
            var message = "La solicitud actual contiene comentarios";
            throw new MembershipRequestWithCommentsExcepcion(message);
        }

        memoryEntityStorage.getMembershipRequests().remove(id);
        currentMembersipRequest.getMember().getMembershipRequests().remove(currentMembersipRequest);
        currentMembersipRequest.getFamily().getMembershipRequests().remove(currentMembersipRequest);
    }

    private MembershipRequest getById(Integer id) throws MembershipRequestEntityNotFoundException, Exception {
        var request = memoryEntityStorage.getMembershipRequests().get(id);
        if (request == null) {
            throw new MemberEntityNotFoundException("La solicitud con Id  con Id: " + id + " no existe");
        }
        return request;
    }

    private boolean exists(Integer id) {
        return memoryEntityStorage.getMembershipRequests().containsKey(id);
    }

    private int getNextId() {
        return (memoryEntityStorage.getMembershipRequests()
                .values()
                .stream()
                .map(MembershipRequest::getId)
                .max(Comparator.naturalOrder())
                .orElse(0)) + 1;
    }

   

}
