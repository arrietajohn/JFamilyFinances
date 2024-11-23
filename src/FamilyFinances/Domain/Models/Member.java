package FamilyFinances.Domain.Models;

import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author johnarrieta
 */
public class Member extends User {

    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String occupation;
    private FamilyRoleEnum familyRole;
    private String cellPhoneNumber;
    private Family family;
    private Set<Income> incomes  = new TreeSet<>();
    private Set<Expense> expenses =  new TreeSet<>();
    private Set<MembershipRequest> membershipRequests = new TreeSet<>();

    public Member(
            String firstName,
            String secondName,
            String firstLastName,
            String secondLastName,
            FamilyRoleEnum familyRole,
            Family family,
            String code,
            String password,
            String name,
            String email,
            Role role
    ) {
        super(code, password, name, email, role);
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.familyRole = familyRole;
        this.family = family;
    }

    public Member(
            String firstName,
            String secondName,
            String firstLastName,
            String secondLastName,
            String gender,
            LocalDate dateOfBirth,
            String occupation,
            FamilyRoleEnum familyRole,
            String cellPhoneNumber,
            Family family,
            Set<Income> incomes,
            Set<Expense> expenses,
            Integer id,
            String code,
            String password,
            String name,
            String email,
            UserStatusEnum status,
            Role role,
            LocalDateTime creationDate,
            LocalDateTime updateDate,
            User createdBy,
            User updateBy
    ) {
        super(id, code, password, name, email, status, role, null, creationDate, updateDate, createdBy, updateBy);
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.occupation = occupation;
        this.familyRole = familyRole;
        this.cellPhoneNumber = cellPhoneNumber;
        this.family = family;
        this.incomes = incomes;
        this.expenses = expenses;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public FamilyRoleEnum getFamilyRole() {
        return familyRole;
    }

    public void setFamilyRole(FamilyRoleEnum familyRole) {
        this.familyRole = familyRole;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Set<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(Set<Income> incomes) {
        this.incomes = incomes;
    }

    public Set<MembershipRequest> getMembershipRequests() {
        return membershipRequests;
    }

    public void setMembershipRequests(Set<MembershipRequest> membershipRequests) {
        this.membershipRequests = membershipRequests;
    }

}
