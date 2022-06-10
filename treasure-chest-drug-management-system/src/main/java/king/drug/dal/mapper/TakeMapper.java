package king.drug.dal.mapper;

import king.drug.api.dtoreq.OutstorageReqDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:54
 */
@Mapper
public interface TakeMapper {
    int insertOutStorage(OutstorageReqDTO outstorage);
}
