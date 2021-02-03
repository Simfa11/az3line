package com.example.az.model;

import javax.persistence.*;

@Entity
@Table(name = "ac_transactions")
public class ACTransaction {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Column(name = "amount")
    private Long amount;

    @Column(name = "outlet")
    private String outlet;

    @Column(name = "tran_type")
    private String tranType;

    @Column(name = "tran_id")
    private String tranId;

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getOutlet() {
        return outlet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

}
