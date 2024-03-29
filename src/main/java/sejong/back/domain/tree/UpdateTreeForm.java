package sejong.back.domain.tree;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class UpdateTreeForm {

    @NotBlank
    private String title;//제목

    @NotBlank
    private String description;//간단한 설명


    private List<Integer> tags;

    private boolean requestId;
    private boolean requestDepartment;


}
