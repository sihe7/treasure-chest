package king.drug.dal.mapper;

import king.drug.api.dtoreq.BuyerReqDTO;
import king.drug.api.dtoreq.UserReqDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: hemenghao
 * @date: 2022/3/19 14:11
 */
@Mapper
public interface UserMapper {
    UserReqDTO findUser(UserReqDTO user);

    int registUser(UserReqDTO user);

    UserReqDTO getUserByAcc(String acc);

    int registBuyer(BuyerReqDTO buyer);

    BuyerReqDTO getBuyerById(int buyerId);

    int deleteUser(String acc);

    int deleteBuyer(int buyerId);

    int updateBuyer(BuyerReqDTO buyer);
}
