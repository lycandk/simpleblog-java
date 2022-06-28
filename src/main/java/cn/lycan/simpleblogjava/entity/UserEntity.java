package cn.lycan.simpleblogjava.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 * 表单数据提交的时候，前端的校验我们可以使用一些类似于jQuery Validate等js插件实现，
 * 而后端我们可以使用Hibernate validatior来做校验。
 * 我们使用springboot框架作为基础，那么就已经自动集成了Hibernate validatior。
 *
 * @author yuwen
 * @since 2022-06-28
 */
@Data
@ToString
@TableName("m_user")
public class UserEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    
    @NotBlank(message = "昵称不能为空")
    @TableField("username")
    private String username;
    
    @TableField("avatar")
    private String avatar;
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @TableField("email")
    private String email;
    
    @TableField("`password`")
    private String password;
    
    @TableField("`status`")
    private Integer status;
    
    @TableField("created")
    private LocalDateTime created;
    
    @TableField("last_login")
    private LocalDateTime lastLogin;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public LocalDateTime getCreated() {
        return created;
    }
    
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }
    
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username=" + username +
                ", avatar=" + avatar +
                ", email=" + email +
                ", password=" + password +
                ", status=" + status +
                ", created=" + created +
                ", lastLogin=" + lastLogin +
                "}";
    }
}
