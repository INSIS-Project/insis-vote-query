package com.isep.acme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReview;

    @Column(nullable = false)
    private String approvalStatus = "pending";

    
    @OneToMany(mappedBy="review", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Vote> votes = new HashSet<Vote>();
    
    public Boolean setApprovalStatus(String approvalStatus) {

        if (approvalStatus.equalsIgnoreCase("pending") ||
                approvalStatus.equalsIgnoreCase("approved") ||
                approvalStatus.equalsIgnoreCase("rejected")) {

            this.approvalStatus = approvalStatus;
            return true;
        }
        return false;
    }
    
    public void addVote(Vote vote){
        if (this.approvalStatus.equals("approved"))
            this.votes.add(vote);
        else throw new IllegalArgumentException("Review is not approved");
    }
}
