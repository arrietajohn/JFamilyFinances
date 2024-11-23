package FamilyFinances.Domain.Models;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author johnarrieta
 */
public class MembershipRequestComment implements Comparable<MembershipRequestComment> {

    private Integer id;
    private LocalDateTime date;
    private String text;
    private Member author;
    private MembershipRequest membershipRequest;
    private Set<MembershipRequestComment> replies = new TreeSet<>();
    private Set<Member> membersLike = new TreeSet<>();

    public MembershipRequestComment(LocalDateTime date, String text, Member author,
            MembershipRequest membershipRequest) {
        this.date = date;
        this.text = text;
        this.author = author;
        this.membershipRequest = membershipRequest;
    }

    public MembershipRequestComment(Integer id, LocalDateTime date, String text,
            Member author, MembershipRequest membershipRequest) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.author = author;
        this.membershipRequest = membershipRequest;
    }

    public int compareTo(MembershipRequestComment other) {
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
        MembershipRequestComment theOther = (MembershipRequestComment) other;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Member getAuthor() {
        return author;
    }

    public void setAuthor(Member author) {
        this.author = author;
    }

    public MembershipRequest getMembershipRequest() {
        return membershipRequest;
    }

    public void setMembershipRequest(MembershipRequest membershipRequest) {
        this.membershipRequest = membershipRequest;
    }

    public Set<MembershipRequestComment> getReplies() {
        return replies;
    }

    public void setReplies(Set<MembershipRequestComment> replies) {
        this.replies = replies;
    }

    public Set<Member> getMembersLike() {
        return membersLike;
    }

    public void setMembersLike(Set<Member> membersLike) {
        this.membersLike = membersLike;
    }

}
