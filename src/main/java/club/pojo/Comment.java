package club.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.baomidou.mybatisplus.annotations.TableField;

import java.util.Date;
import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-08-20 14:23
 */
@Data
public class Comment {
    private Integer id;
    private Integer userId;
    private Integer adminsId;
    private Integer petId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date commentTime;
    private String content;
    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private Admins admin;
    @TableField(exist = false)
    private Pet pet;
    @TableField(exist = false)
    private List<Answer> answer;

}
