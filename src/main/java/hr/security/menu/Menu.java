package hr.security.menu;
import io.swagger.annotations.ApiModel;import io.swagger.annotations.ApiModelProperty;import org.springframework.stereotype.Component;import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_Menu")
@Component
@ApiModel(value="",description="")
public class Menu implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@ApiModelProperty(value = "")
private Integer id;

@Column()
@ApiModelProperty(value = "")
private String pattern;


public void setId(Integer id){
this.id=id ;
 }
public Integer getId(){
return this.id ;
 }
public void setPattern(String pattern){
this.pattern=pattern ;
 }
public String getPattern(){
return this.pattern ;
 }
}