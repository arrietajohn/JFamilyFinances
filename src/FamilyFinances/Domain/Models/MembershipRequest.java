package FamilyFinances.Domain.Models;

/**
 *
 * @author johnarrieta
 */
import FamilyFinances.Domain.Constants.MembershipRequestStatusEnum;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class MembershipRequest implements Comparable<MembershipRequest>{

    private Integer id;
    private LocalDateTime requestDate;
    private MembershipRequestStatusEnum status;
    private Member member;
    private Family family;
    private Member approvedBy;
    private Member rejectedBy;
    private LocalDateTime approvedDate;
    private LocalDateTime rejectionDate;
    private String reasonApproved;
    private String reasonRejected;
    private String reasonForRequest;
    private Set<MembershipRequestComment> comments = new TreeSet<>();

    // Constructor
    public MembershipRequest(
            Integer id,
            LocalDateTime requestDate,
            MembershipRequestStatusEnum status,
            Member member,
            Family family,
            String reasonForRequest) {
        this.id = id;
        this.requestDate = requestDate;
        this.status = status;
        this.member = member;
        this.family = family;
        this.reasonForRequest = reasonForRequest;
    }

    public int compareTo(MembershipRequest other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        MembershipRequest theOther = (MembershipRequest) other;
        return Objects.equals(id, theOther.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public MembershipRequestStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MembershipRequestStatusEnum status) {
        this.status = status;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Member getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Member approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Member getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(Member rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public LocalDateTime getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(LocalDateTime approvatedDate) {
        this.approvedDate = approvatedDate;
    }

    public LocalDateTime getRejectionDate() {
        return rejectionDate;
    }

    public void setRejectionDate(LocalDateTime rejectionDate) {
        this.rejectionDate = rejectionDate;
    }

    public String getReasonApproved() {
        return reasonApproved;
    }

    public void setReasonApproved(String reasonApproved) {
        this.reasonApproved = reasonApproved;
    }

    public String getReasonRejected() {
        return reasonRejected;
    }

    public void setReasonRejected(String reasonRejected) {
        this.reasonRejected = reasonRejected;
    }

    public String getReasonForRequest() {
        return reasonForRequest;
    }

    public void setReasonForRequest(String reasonForRequest) {
        this.reasonForRequest = reasonForRequest;
    }

    public Set<MembershipRequestComment> getComments() {
        return comments;
    }

    public void setComments(Set<MembershipRequestComment> comments) {
        this.comments = comments;
    }

}
