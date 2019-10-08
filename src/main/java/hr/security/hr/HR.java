package hr.security.hr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_HR")
@Component
@ApiModel(value = "", description = "")
public class HR implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "")
    private Integer id;

    @Column()
    @ApiModelProperty(value = "")
    private String username;

    @Column()
    @ApiModelProperty(value = "")
    private String password;

    @Column()
    @ApiModelProperty(value = "")
    private boolean enabled;

    @Column()
    @ApiModelProperty(value = "")
    private String phone;

    @Column()
    @ApiModelProperty(value = "")
    private String address;

    @Column()
    @ApiModelProperty(value = "")
    private String remark;

    @Column()
    @ApiModelProperty(value = "")
    private String userface;

    @Column()
    @ApiModelProperty(value = "")
    private String name;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getUserface() {
        return this.userface;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}