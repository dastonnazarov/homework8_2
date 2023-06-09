package atto.dto;

import atto.enums.TerminalStatus;

import javax.persistence.*;
import java.nio.file.FileSystems;
import java.time.LocalDateTime;
@Entity
@Table(name = "terminal")
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private TerminalStatus status;
    @Column(name = "create_date")
    private LocalDateTime create_date;


    public Terminal() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TerminalStatus getStatus() {
        return status;
    }

    public void setStatus(TerminalStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime created_date) {
        this.create_date = created_date;
    }


    @Override
    public String toString() {
        return "Terminal{" +
                "id=" + id +
                ", code=" + code +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", created_date=" + create_date +
                '}';
    }
}
