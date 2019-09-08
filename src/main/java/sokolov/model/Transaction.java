package sokolov.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sokolov.Status;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private Status status;

    @Column(name = "time")
    private Date time;

    @Column(name = "contract_number")
    private int contract_number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_code")
    @JsonIgnore
    private Code fk_code;

    public Code getCode() {
        return fk_code;
    }

    public void setCode(Code code) {
        this.fk_code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getContract_number() {
        return contract_number;
    }

    public void setContract_number(int contract_number) {
        this.contract_number = contract_number;
    }
}
