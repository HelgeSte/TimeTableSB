package com.stegemoen.timetable.data;

import javax.persistence.*;

@Entity
@Table(name="Companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="company_id")
    private long customerID = 0;

    @Column(name="company_name")
    private String companyName;

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "customerID=" + customerID +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
