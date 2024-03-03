package nl.cms.infra.database.envers;

import java.time.Instant;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@Table(name = "REVINFO")
@RevisionEntity(CMSRevisionEntityListener.class)
public class CMSRevisionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @RevisionNumber
    public Long id;

    @RevisionTimestamp
    public long timestamp;

    @NotBlank
    @Column(nullable = false)
    public String username;

    @NotBlank
    @Column(nullable = false)
    public String notes;

    @Column(nullable = false)
    public Instant affectedStart;

    @Column(nullable = false)
    public Instant affectedEnd;
}
