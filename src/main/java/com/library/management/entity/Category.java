package com.library.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseLookupEntity{
}
