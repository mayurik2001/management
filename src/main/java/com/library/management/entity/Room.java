package com.library.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room extends BaseLookupEntity{
}
