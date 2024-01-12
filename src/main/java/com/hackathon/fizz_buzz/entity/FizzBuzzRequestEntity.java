package com.hackathon.fizz_buzz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Table(name = "FIZZ_BUZZ_REQUEST")
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FizzBuzzRequestEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FIZZ_BUZZ_ID_SEQUENCE")
    @SequenceGenerator(name = "FIZZ_BUZZ_ID_SEQUENCE", sequenceName = "FIZZ_BUZZ_ID_SEQUENCE")
    private Long id;

    @Column(nullable = false)
    private int int1;
    @Column(nullable = false)
    private int int2;
    @Column(name = "PRINT_LIMIT", nullable = false)
    private int limit;
    @Column(nullable = false)
    private String str1;
    @Column(nullable = false)
    private String str2;
    @Column(nullable = false)
    private Integer requestCount;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdTs;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date modifiedTs;

}
