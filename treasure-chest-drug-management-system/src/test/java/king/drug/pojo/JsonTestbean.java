package king.drug.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: hemenghao
 * @date: 2022/4/14 21:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JsonTestbean {
    private Head head;
    private Biz biz;
    @Data
    class Head{
        String method;
        String version;
    }
    @Data
    class Biz{
        int code;
        String msg;
    }
}
