package edu.gdut.myBoot.polo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by Jun on 2018/7/10.
 */
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Book implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @DecimalMin(value = "0", message = "价格有误")
    private float price;

    @Column(nullable = false)
    @Min(value = 0, message = "数量有误")
    private int quantity;

    @Column
    private String description;

    public Book(String name, float price, int quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }
}
