package com.library.management.entity;

import com.library.management.enums.ResourceStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "resources")
@Getter
@Setter
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String isbnBarcode;

    @NotBlank
    @Column(nullable = false)
    private String title;

    private String edition;

    @ElementCollection
    @CollectionTable(
            name = "resource_authors",
            joinColumns = @JoinColumn(name = "resource_id")
    )
    @Column(name = "author_name")
    private List<String> authors;

    @ElementCollection
    @CollectionTable(
            name = "resource_categories",
            joinColumns = @JoinColumn(name = "resource_id")
    )
    @Column(name = "category_name")
    private List<String> categories;

    @ElementCollection
    @CollectionTable(
            name = "resource_publishers",
            joinColumns = @JoinColumn(name = "resource_id")
    )
    @Column(name = "publisher_name")
    private List<String> publishers;

    @ManyToOne
    @JoinColumn(name = "resource_type_id")
    private ResourceType resourceType;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "rack_id")
    private Rack rack;

    @Min(1)
    @Column(nullable = false)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResourceStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {

        this.createdAt = LocalDateTime.now();

        if (this.status == null) {
            this.status = ResourceStatus.AVAILABLE;
        }
    }
}