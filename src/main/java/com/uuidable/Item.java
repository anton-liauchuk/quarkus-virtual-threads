package com.uuidable;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Item extends PanacheEntity {

	public String name;

}
