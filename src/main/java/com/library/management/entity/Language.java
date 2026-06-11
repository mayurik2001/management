package com.library.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="languages")
public class Language extends BaseLookupEntity {
}
