package FamilyFinances.Domain.Models;

import FamilyFinances.Domain.Constants.UserStatusEnum;
import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public class User {

    private Integer id;
    private String code;
    private String password;
    private String name;
    private String email;
    private UserStatusEnum status;
    private Role role;
    private Member member;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private User createdBy;
    private User updateBy;

    public User(int id) {
        this.id = id;
    }
    
    public User(String code, String password, String name, String email, Role role) {
        this.code = code;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public User(Integer id, String code, String password, String name, String email, UserStatusEnum status, Role role, Member member, LocalDateTime creationDate, LocalDateTime updateDate, User createdBy, User updateBy) {
        this.id = id;
        this.code = code;
        this.password = password;
        this.name = name;
        this.email = email;
        this.status = status;
        this.role = role;
        this.member = member;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.createdBy = createdBy;
        this.updateBy = updateBy;
    }

    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
    
}
