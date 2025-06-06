package com.valoores.user_management_service.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

// import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true,nullable = false)
    private String email;

    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String passwordHash;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedOn;

    // @PrePersist
    // protected void onCreate(){
    //     this.createdOn = LocalDateTime.now();
    //     this.updatedOn = LocalDateTime.now();
    // }

    // @PreUpdate
    // protected void onUpdate(){
    //     this.updatedOn = LocalDateTime.now();
    // }

}
